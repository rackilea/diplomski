package org.stackoverflow.helizone.test;

public class Application {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.setHeight(true);
        configuration.setWidth(true);
        configuration.setIsValid(false);

        ConfigurationProcessor cp = new ConfigurationProcessor();

        String result = cp.toJson(configuration);

        System.out.println(result);
    }
}