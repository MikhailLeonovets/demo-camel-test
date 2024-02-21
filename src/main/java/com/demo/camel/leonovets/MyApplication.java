package com.demo.camel.leonovets;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import io.micrometer.jmx.JmxMeterRegistry;
import org.apache.camel.component.micrometer.CamelJmxConfig;
import org.apache.camel.main.Main;

/**
 * Main class that boot the Camel application
 */
public final class MyApplication {
    private MyApplication() {
    }

    public static void main(String[] args) throws Exception {
        CompositeMeterRegistry registry = new CompositeMeterRegistry();
        registry.add(new JmxMeterRegistry(
                CamelJmxConfig.DEFAULT,
                Clock.SYSTEM,
                HierarchicalNameMapper.DEFAULT
        ));

        Main main = new Main(MyApplication.class);
        main.configure().setRoutesCollectorEnabled(false);
        main.bind("myBean", new MyBean("hi", "bye"));
        main.run(args);
    }

}
