package com.demo.camel.leonovets;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author Mikhail.Leonovets
 * @since 02/2024
 */
public class MyHttpRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("jetty:http://localhost:8080/welcome")
            .process(exchange -> exchange.getIn().setBody("IM HERE !!!!"))
                .end();
    }
}
