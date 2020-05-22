ClassPathResource resource = new ClassPathResource( "app.properties" );
p = new Properties();
InputStream inputStream = null;
try {
    inputStream = resource.getInputStream();
    p.load( inputStream );
} catch ( IOException e ) {
    LOGGER.error( e.getMessage(), e );
} finally {
    Closeables.closeQuietly( inputStream );
}