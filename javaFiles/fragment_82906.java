/**
 * Create a remote download repository.
 * @param url the URL of the repository
*/
public MavenArtifactRepository(..., String url, ...) {
    ...
    this.basedir = basedir( url );
}


/**
 * Derive the path portion of the given URL.
 * @param url the repository URL
*/
private String basedir( String url ) {
    if ( protocol.equalsIgnoreCase( "file" ) ) {
        retValue = url.substring( protocol.length() + 1 );
        retValue = decode( retValue );
    ...
}

/**
 * Decodes the specified (portion of a) URL. <strong>Note:</strong> This decoder assumes that ISO-8859-1 is used to
 * convert URL-encoded bytes to characters.
 *
 * @param url The URL to decode, may be <code>null</code>.
 * @return The decoded URL or <code>null</code> if the input was <code>null</code>.
 */
private static String decode( String url )
{
    String decoded = url;
    if ( url != null )
    {
        int pos = -1;
        while ( ( pos = decoded.indexOf( '%', pos + 1 ) ) >= 0 )
        {
            if ( pos + 2 < decoded.length() )
            {
                String hexStr = decoded.substring( pos + 1, pos + 3 );
                char ch = (char) Integer.parseInt( hexStr, 16 );
                decoded = decoded.substring( 0, pos ) + ch + decoded.substring( pos + 3 );
            }
        }
    }
    return decoded;
}