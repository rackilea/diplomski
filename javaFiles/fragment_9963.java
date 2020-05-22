/**
 * Strips any potential XSS threats out of the value
 *
 * @param value
 * @return
 */
public static String stripXSS( String value )
{
    return stripXSS( value, Whitelist.none() );
}


/**
 * Strips any potential XSS threats out of the value excluding
 * the white listed HTML
 *
 * @param value
 * @param whitelist
 * @return
 */
public static String stripXSS( String value, Whitelist whitelist )
{
    if( StringUtils.isBlank( value ) )
        return value;

    // Use the ESAPI library to avoid encoded attacks.
    value = ESAPI.encoder().canonicalize( value );

    // Avoid null characters
    value = value.replaceAll("\0", "");

    // Clean out HTML
    Document.OutputSettings outputSettings = new Document.OutputSettings();
    outputSettings.escapeMode( EscapeMode.xhtml );
    outputSettings.prettyPrint( false );
    value = Jsoup.clean( value, "", whitelist, outputSettings );

    return value;
}