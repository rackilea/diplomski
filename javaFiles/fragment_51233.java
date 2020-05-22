static class UserInfo
{
    public static void myMethod()
    {
        File startingFile = new File(".");
        String startingPath = "dummy";
        try
        {
            startingPath = startingFile.getCanonicalPath();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}