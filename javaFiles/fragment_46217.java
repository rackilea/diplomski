try{
    long converted = Long.valueOf( "TEST" );
    System.out.println( converted );
}
catch( NumberFormatException e ){
    System.out.println( "Your input is wrong.." );
}