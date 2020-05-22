package com.busytrack.discographymanager.headerfixagent;
import java.lang.instrument.Instrumentation;
public class MyJavaAgent {
public static void premain(String agentArgument, Instrumentation instrumentation) {
    ClassTransformer transformer = new ClassTransformer();
    instrumentation.addTransformer(transformer);
    }
}