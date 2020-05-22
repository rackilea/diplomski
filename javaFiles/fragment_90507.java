package phil.agent;

public class Agent {

    public static void premain ( String agentArguments, Instrumentation ins ) {
        try {
            ins.appendToBootstrapClassLoaderSearch ( 
                new JarFile ( 
                    new File ( "path/to/Agent.jar" ) ) );
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
        ins.addTransformer ( new Transformer (), true );
        Class<?>[] classes = ins.getAllLoadedClasses ();
        int len = classes.length;
        for ( int i = 0; i < len; i++ ) {
            Class<?> clazz = classes[i];
            String name = clazz != null ? clazz.getCanonicalName () : null;
            try {
                if ( name != null && !clazz.isArray () && !clazz.isPrimitive ()
                        && !clazz.isInterface () 
                        && !name.equals ( "java.lang.Long" )
                        && !name.equals ( "java.lang.Boolean" )
                        && !name.equals ( "java.lang.Integer" )
                        && !name.equals ( "java.lang.Double" ) 
                        && !name.equals ( "java.lang.Float" )
                        && !name.equals ( "java.lang.Number" ) 
                        && !name.equals ( "java.lang.Class" )
                        && !name.equals ( "java.lang.Byte" ) 
                        && !name.equals ( "java.lang.Void" )
                        && !name.equals ( "java.lang.Short" ) 
                        && !name.equals ( "java.lang.System" )
                        && !name.equals ( "java.lang.Runtime" )
                        && !name.equals ( "java.lang.Compiler" )
                        && !name.equals ( "java.lang.StackTraceElement" )
                        && !name.startsWith ( "java.lang.ThreadLocal" )
                        && !name.startsWith ( "sun." ) 
                        && !name.startsWith ( "java.security." )
                        && !name.startsWith ( "java.lang.ref." )
                        && !name.startsWith ( "java.lang.ClassLoader" )
                        && !name.startsWith ( "java.util.concurrent.atomic" )
                        && !name.startsWith ( "java.util.concurrent.ConcurrentHashMap" )
                        && !name.startsWith ( "java.util.concurrent.locks." )
                        && !name.startsWith ( "phil.agent." ) ) {
                    ins.retransformClasses ( clazz );
                }
            } catch ( Throwable e ) {
                System.err.println ( "Cant modify: " + name );
            }
        }

        Runtime.getRuntime ().addShutdownHook ( new Thread () {
            @Override
            public void run () {
                MaxStackLog.dumpMax ();
            }
        } );
    }
}