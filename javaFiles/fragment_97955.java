Map<String,Set<String>> dir2names = new HashMap<>();
for( File f: filesToCopy ){
    String name = f.getName();
    // test name for null and do error handling
    String dir = f.getParent();
    // dir for null and do error handling
    Set<String> names = dir2names.get( dir );
    if( names == null ){
        names = new HashSet<>();
        dir2names.put( dir, names );
    }
    names.add( name );
}