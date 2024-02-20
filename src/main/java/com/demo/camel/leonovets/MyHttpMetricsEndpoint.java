package com.demo.camel.leonovets;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author Mikhail.Leonovets
 * @since 02/2024
 */
public class MyHttpMetricsEndpoint extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("platform-http:/localhost:8081")
                .routeId("get")
                .setBody().constant("Hello from Camel's PlatformHttp service");
    }
}
