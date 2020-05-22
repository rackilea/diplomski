public static String convertStreamToString( InputStream is, String ecoding ) throws IOException
{
    StringBuilder sb = new StringBuilder( Math.max( 16, is.available() ) );
    char[] tmp = new char[ 4096 ];

    try {
       InputStreamReader reader = new InputStreamReader( is, ecoding );
       for( int cnt; ( cnt = reader.read( tmp ) ) > 0; )
            sb.append( tmp, 0, cnt );
    } finally {
        is.close();
    }
    return sb.toString();
}