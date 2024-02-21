FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY prometheus ./prometheus

RUN mvn prepare-package package

FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build ./app/target/camel-demo-1.0-SNAPSHOT.jar .
COPY --from=build ./app/prometheus/config.yaml ./prometheus/config.yaml
COPY jmx_prometheus_javaagent-0.20.0.jar ./
CMD ["java", "-javaagent:./jmx_prometheus_javaagent-0.20.0.jar=8081:./prometheus/config.yaml", "-jar", "camel-demo-1.0-SNAPSHOT.jar"]