public static void main(String[] args) {
    try {
        final Thread t = new Thread( new Runnable() {
            public void run() {
                System.out.println( 3 / Math.min(0,4) );
            }
        } );
        t.start();
    catch(Throwable t) {
        ...
    }
}