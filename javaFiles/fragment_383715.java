public static String UTF8toISO( String str )
    {
        try
        {
            return new String( str.getBytes( "ISO-8859-1" ), "UTF-8" );
        }
        catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        return str;
    }