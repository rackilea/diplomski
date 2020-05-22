package com.asimio.jerseyexample.config;
...
@Component
public class JerseyConfig extends ResourceConfig {

    ...        
    public JerseyConfig() {
        // Register endpoints, providers, ...
        this.registerEndpoints();
    }

    private void registerEndpoints() {
        this.register(HelloResource.class);
        // Access through /<Jersey's servlet path>/application.wadl
        this.register(WadlResource.class);
    }
}