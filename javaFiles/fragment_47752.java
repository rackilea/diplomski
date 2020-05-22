String registerImage( String resourceName ) throws IOException {
  IResourceManager resourceManager = RWT.getResourceManager();
  if( !resourceManager.isRegistered( resourceName ) ) {
    InputStream inputStream = CLASSLOADER.getResourceAsStream( resourceName );
    try {
      resourceManager.register( resourceName, inputStream );
    } finally {
      inputStream.close();
    }
  }
  return resourceManager.getLocation( resourceName );
}