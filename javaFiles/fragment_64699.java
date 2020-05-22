Runtime.getRuntime().addShutdownHook( thread );
try {
    System.out.println( "Sleeping" );
    Thread.sleep( 5000);
    System.out.println( "Waking" );
} catch( Exception e ){
}