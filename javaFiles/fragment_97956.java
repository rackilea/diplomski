for( String dirname: dir2names.keySet() ){
    File[] entries = new File( dirname ).listFiles();
    if( entries.length > dir2names.get( dirname ).size() ){
        // add list created from dirname + set of names to files to copy
        for( String name: dir2names.get( dirname ){
            String pathname = new File( dirname, name ).getAbsolutePath();
            // add pathname to files to copy
        }
    } else {
        // add directory identified by dirname to files to copy
    }
}