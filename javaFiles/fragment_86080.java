public static Path findAbsolutePath( String curl ){
  String path = System.getenv( "PATH" );
  String[] dirs = path.split( ";" );
  for( String dir: dirs ){
    Path toCurl = Paths.get( dir, curl );
    File curlFile = new File( toCurl.toString() );
    if( curlFile.canExecute() ) return toCurl;
  }
  return null;
}