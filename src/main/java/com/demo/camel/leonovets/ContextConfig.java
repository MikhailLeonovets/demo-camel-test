package com.demo.camel.leonovets;

import org.apache.camel.CamelConfiguration;
import org.apache.camel.CamelContext;
import org.apache.camel.component.micrometer.prometheus.MicrometerPrometheus;
import org.apache.camel.component.platform.http.vertx.VertxPlatformHttpRouter;
import org.apache.camel.component.platform.http.vertx.VertxPlatformHttpServer;
import org.apache.camel.component.platform.http.vertx.VertxPlatformHttpServerConfiguration;

/**
 * @author Mikhail.Leonovets
 * @since 02/2024
 */
public class ContextConfig implements CamelConfiguration {

    @Override
    public void configure(final CamelContext context) throws Exception {
/*        CamelConfiguration.super.configure(context);
        VertxPlatformHttpServerConfiguration conf = new VertxPlatformHttpServerConfiguration();
        conf.setBindPort(8081);
        context.addService(new VertxPlatformHttpServer(conf));
        context.addService(new MicrometerPrometheus());*/
    }
}
