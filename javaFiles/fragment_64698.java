static void rec(){ rec(); }

public static void main( String[] args ){

    Thread thread = new Thread(){
        public void run(){
            System.out.println( "SHUTDOWN" );
        }
    };
    Runtime.getRuntime().addShutdownHook( thread );
    rec();
}