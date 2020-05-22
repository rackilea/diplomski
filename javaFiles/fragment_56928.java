public void find( File root, Map<String, String> map ){
    File[] entries = root.listFiles();
    for( File file: entries ){
        if( file.isDirectory() ){
            find( file, map );
        } else {
            map.put( file.getName(), file.getAbsolutePath() );
        }
    }
}

public void comp( File root1, File root2 ){
    Map<String,String> map1 = new HashMap<>();
    find( root1, map1 );
    Map<String,String> map2 = new HashMap<>();
    find( root2, map2 );
    for( String name1: map1.keySet() ){
        String path1 = map1.get( name1 );
        String path2 = map2.get( name1 );
        System.out.println( name1 + ": " + path1 + "->" + path2 ); 
    }
}