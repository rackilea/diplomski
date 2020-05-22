File file = null;
try
{
    file = new File(Environment.getRootDirectory().getPath().toString(), "/etc/init.d/script");
}
catch (Exception e)
{
    // Cannot get file so set permissions.
    Runtime.getRuntime().exec(new String[] { "su", "-c", "chown 777 /etc/init.d/script" });
    try
    {
        file = new File(Environment.getRootDirectory().getPath().toString(), "/etc/init.d/script");
    }
    catch (Exception e)
    {
        // File does not exits, so create it.
        Runtime.getRuntime().exec(new String[] { "su", "-c", "echo '#' > /etc/init.d/script" });
        // Now set permissions.
        Runtime.getRuntime().exec(new String[] { "su", "-c", "chown 777 /etc/init.d/script" });
        try
        {
            file = new File(Environment.getRootDirectory().getPath().toString(), "/etc/init.d/script");
        }
        catch (Exception e)
        {
             // Should never get here.
        }    
}

// Do stuff with your file.