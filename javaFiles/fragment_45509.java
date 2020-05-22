private static final String defaultFunctions = 
     com.google.common.io.Files.toString(new File("functions.js"),Charsets.US_ASCII);

private String convertPsuedoFunctions(String mask)
{
    return defaultFunctions + mask;
}