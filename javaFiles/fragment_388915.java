public static boolean isProcessRunning(Process process) 
{
    try 
    {
        process.exitValue();
        return false;
    } 
    catch(IllegalThreadStateException e) 
    {
        return true;
    }
}