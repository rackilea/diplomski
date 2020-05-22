public static void main(String[] args) {

    List<String> filePaths = getFilePathsFromXML( "xtf.xml" );

    for ( String path : filePaths ) {
        deleteRecursively( path );
    }
}

/**
 * Deletes a file or folder. If a given path is a folder then deletes all files and folders recursively first
 *
 * @param String path - path of a file or directory
**/
static void deleteRecursively( String path ) {
    File file = new File( path );
    if ( file.isDirectory() ) {
        for ( String subPath : file.list() ) {
            deleteRecursively( subPath );
        }
    }
    try {
        file.delete();
    } catch ( Exception e ) {
        e.printStackTrace();
    }
}

/**
 * Gets a list of file pats from an XML file.
 *
 * @param String fileName - the XML file name for reading
**/
static List<String> getFilePathsFromXML( String fileName ) {
    List<String> result = new ArrayList<String>();
    // figure out how to read paths from file
    return result;
}