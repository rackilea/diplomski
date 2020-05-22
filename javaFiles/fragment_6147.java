public static void main( String[] args ) {
    String input = "city^chennai|country^India~TamilNadu|pincode^600034";
    String[] things = input.replaceAll( "~", "," ).split( "[^\\w,]" );
    Map<String, String> map = new HashMap<String, String>( );
    for (int i = 0; i < things.length; i+=2) {
        map.put(things[i], things[i+1]);
    }
    System.out.println( map );
}