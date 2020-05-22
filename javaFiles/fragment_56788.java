public static boolean open(File file)
{
    try
    {
        if (OSDetector.isWindows())
        {
            Runtime.getRuntime().exec(new String[]
            {"rundll32", "url.dll,FileProtocolHandler",
             file.getAbsolutePath()});
            return true;
        } else if (OSDetector.isLinux() || OSDetector.isMac())
        {
            Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
                                                   file.getAbsolutePath()});
            return true;
        } else
        {
            // Unknown OS, try with desktop
            if (Desktop.isDesktopSupported())
            {
                Desktop.getDesktop().open(file);
                return true;
            }
            else
            {
                return false;
            }
        }
    } catch (Exception e)
    {
        e.printStackTrace(System.err);
        return false;
    }
}