public aspect CallStackAdvice {

   pointcut allMethods() : execution(* *(..)) && !within(CallStackLog);

   Object around(): allMethods(){
       String called = thisJoinPoint.getSignature ().toLongString ();
       CallStackLog.calling ( called );
       try {
           return proceed();
       } finally {
           CallStackLog.exiting ( called );
       }
   }

}

public class CallStackLog {

    private CallStackLog () {}

    private static ThreadLocal<ArrayDeque<String>> curStack = 
        new ThreadLocal<ArrayDeque<String>> () {
        @Override
        protected ArrayDeque<String> initialValue () {
            return new ArrayDeque<String> ();
        }
    };

    private static ThreadLocal<Boolean> ascending = 
        new ThreadLocal<Boolean> () {
        @Override
        protected Boolean initialValue () {
            return true;
        }
    };

    private static ConcurrentHashMap<Integer, ArrayDeque<String>> stacks = 
         new ConcurrentHashMap<Integer, ArrayDeque<String>> ();

    public static void calling ( String signature ) {
        ascending.set ( true );
        curStack.get ().push ( signature.intern () );
    }

    public static void exiting ( String signature ) {
        ArrayDeque<String> cur = curStack.get ();
        if ( ascending.get () ) {
            ArrayDeque<String> clon = cur.clone ();
            stacks.put ( hash ( clon ), clon );
        }
        cur.pop ();
        ascending.set ( false );
    }

    public static Integer hash ( ArrayDeque<String> a ) {
        //simplistic and wrong but ok for example
        int h = 0;
        for ( String s : a ) {
            h += ( 31 * s.hashCode () );
        }
        return h;
    }

    public static void dumpStacks(){
        //implement something to print or retrieve or use stacks
    }
}