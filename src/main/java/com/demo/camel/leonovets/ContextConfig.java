package com.demo.camel.leonovets;

import org.apache.camel.CamelConfiguration;
import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;

/**
 * @author Mikhail.Leonovets
 * @since 02/2024
 */
public class ContextConfig implements CamelConfiguration {

    @Override
    public void configure(final CamelContext context) throws Exception {
        CamelConfiguration.super.configure(context);

        MetricsRoutePolicyFactory metricsRoutePolicyFactory = new MetricsRoutePolicyFactory();
        metricsRoutePolicyFactory.setUseJmx(true);
        context.addRoutePolicyFactory(metricsRoutePolicyFactory);
        context.addRoutes(new MyRouteBuilder());
        context.addRoutes(new MyHttpRouteBuilder());
        context.addService(new MyHttpMetricsEndpoint());

    }
}
