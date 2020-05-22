class FileManager
{
    public static void copy(String src, String dest) throws RootDeniedException, IOException, TimeoutException
    {
        String command = "cp -r " + src + " " + dest;
        CommandCapture cmdCapture = new CommandCapture(0, command);
        RootTools.getShell(true).add(cmdCapture);
    }
}