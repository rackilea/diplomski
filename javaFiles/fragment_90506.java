package phil.agent;

public class MaxStackLog {

    private static ThreadLocal<Integer> curStackSize = 
        new ThreadLocal<Integer> () {
        @Override
        protected Integer initialValue () {
            return 0;
        }
    };

    private static ThreadLocal<Integer> curStackDepth = 
        new ThreadLocal<Integer> () {
        @Override
        protected Integer initialValue () {
            return 0;
        }
    };

    private static ThreadLocal<Boolean> ascending = 
        new ThreadLocal<Boolean> () {
        @Override
        protected Boolean initialValue () {
            return true;
        }
    };

    private static ConcurrentHashMap<Long, Integer> maxSizes = 
        new ConcurrentHashMap<Long, Integer> ();
    private static ConcurrentHashMap<Long, Integer> maxDepth = 
        new ConcurrentHashMap<Long, Integer> ();

    private MaxStackLog () { }

    public static void enter ( int frameSize ) {
        ascending.set ( true );
        curStackSize.set ( curStackSize.get () + frameSize );
        curStackDepth.set ( curStackDepth.get () + 1 );
    }

    public static void exit ( int frameSize ) {
        int cur = curStackSize.get ();
        int curDepth = curStackDepth.get ();
        if ( ascending.get () ) {
            long id = Thread.currentThread ().getId ();
            Integer max = maxSizes.get ( id );
            if ( max == null || cur > max ) {
                maxSizes.put ( id, cur );
            }
            max = maxDepth.get ( id );
            if ( max == null || curDepth > max ) {
                maxDepth.put ( id, curDepth );
            }
        }
        ascending.set ( false );
        curStackSize.set ( cur - frameSize );
        curStackDepth.set ( curDepth - 1 );
    }

    public static void dumpMax () {
        int max = 0;
        for ( int i : maxSizes.values () ) {
            max = Math.max ( i, max );
        }
        System.out.println ( "Max stack frame size accummulated: " + max );
        max = 0;
        for ( int i : maxDepth.values () ) {
            max = Math.max ( i, max );
        }
        System.out.println ( "Max stack depth: " + max );
    }
}