/**
 * Takes in a CSR/p10 as a string and removes the headers and footers of the request string.
 * 
 * @param inString a CSR string
 * @return a CSR String stripped of the text headers and footers
 */
public static String removeCSRHeadersAndFooters(String inString)
{
    logger.debug("pemString: [" + inString + "]");

    inString = inString.replace("-----BEGIN CERTIFICATE REQUEST-----" + "\n", "");
    inString = inString.replace("\n" + "-----END CERTIFICATE REQUEST-----" + "\n", "");

    logger.debug("[" + inString + "]");

    return inString;
}