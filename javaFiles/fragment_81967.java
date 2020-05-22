public class BasicAgent {
                public static void premain(String agentArguments, Instrumentation instrumentation){
                    System.out.println("Simple Agent");
                    FindUsageTransformer transformer = new FindUsageTransformer ();
                    instrumentation.addTransformer(transformer,true);
                }
            }