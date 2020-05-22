package org.foo;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        // initialize here
        packages("the.packages.to.scan");
    }
}