switch ( myURI.getScheme() ) {
  case "http":
    return myURI.toURL().openConnection().getInputStream();
  case "ftp":
    // do something   
  case "file":
    return new FileInputStream( Paths.get(myURI).toFile() );
}