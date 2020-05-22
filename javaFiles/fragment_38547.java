public int runCommand(String command) throws IOException
{
    int returnValue = -1;
    try {
        Process process = Runtime.getRuntime().exec( command );
        process.waitFor();
        returnValue = process.exitValue();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    return returnValue;
}