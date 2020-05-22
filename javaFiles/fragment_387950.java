public static void writePID(String fileLocation) throws IOException
{
    // Use the engine management bean in java to find out the pid
    // and to write to a file
    if (fileLocation.length() == 0)
    {
        fileLocation = DEFAULT_PID_FILE;
    }       
    String pid = ManagementFactory.getRuntimeMXBean().getName();
    if (pid.indexOf("@") != -1) 
    {
        pid = pid.substring(0, pid.indexOf("@"));
    }                                               
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation));
    writer.write(pid);
    writer.newLine();
    writer.flush();
    writer.close();                     
}