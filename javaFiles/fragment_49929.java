private static final String FILE = "file";
private static final String CHARSET = "charset";

public static BufferedReader createReader( File file, Encoding charset ) throws IOException {
    JavaUtils.notNull( FILE, file );
    JavaUtils.notNull( CHARSET, charset );

    FileInputStream stream = null;
    try {
        stream = new FileInputStream( file );
        return createReader( stream, charset );
    } catch( IOException e ) {
        IOUtils.closeQuietly( stream );
        throw e;
    } catch( RuntimeException e ) {
        IOUtils.closeQuietly( stream );
        throw e;
    }
}

public static BufferedReader createReader( InputStream stream, Encoding charset ) throws IOException {
    JavaUtils.notNull( "stream", stream );
    JavaUtils.notNull( "charset", charset );

    try {
        return new BufferedReader( new InputStreamReader( stream, charset.encoding() ) );
    } catch( UnsupportedEncodingException e ) {
        IOUtils.closeQuietly( stream );
        throw new UnknownEncodingException( charset, e );
    } catch( RuntimeException e ) {
        IOUtils.closeQuietly( stream );
        throw e;
    }
}

public static BufferedWriter createWriter( File file, Encoding charset ) throws IOException {
    JavaUtils.notNull( FILE, file );
    JavaUtils.notNull( CHARSET, charset );

    FileOutputStream stream = null;
    try {
        stream = new FileOutputStream( file );
        return new BufferedWriter( new OutputStreamWriter( stream, charset.encoding() ) );
    } catch( UnsupportedEncodingException e ) {
        IOUtils.closeQuietly( stream );
        throw new UnknownEncodingException( charset, e );
    } catch( IOException e ) {
        IOUtils.closeQuietly( stream );
        throw e;
    } catch( RuntimeException e ) {
        IOUtils.closeQuietly( stream );
        throw e;
    }
}