private static String readAllBytes(String filePath) 
{
    String content = "";
    try
    {
        content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }
    return content;
}