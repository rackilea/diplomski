package de.scrum_master.app;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        for (String argument : arguments) {
            if (argument.startsWith("-javaagent:"))
                System.out.println(argument);
        }
        try {
            Class.forName("org.aspectj.weaver.loadtime.Agent");
        } catch (ClassNotFoundException e) {
            System.err.println("WARNING: AspectJ weaving agent not loaded");
        }
    }
}