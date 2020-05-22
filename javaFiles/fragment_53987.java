String[] fullargs = new String[sargs.length+4];
fullargs[0] = "java";
fullargs[1] = "-classpath";   // Runtime classpath option.
fullargs[2] = cpath;          // Specify the classpath.
fullargs[3] = mname;          // Specify class to run.

for(int i=0; i<sargs.length; i++)
{
    fullargs[i+4] = sargs[i]; // Put together arguments.
}

ProcessBuilder pb = new ProcessBuilder().command(fullargs);

try
{
    System.out.println("RUNNING...");
    Process p = pb.start();
    StreamGobbler pOut = new StreamGobbler(p.getInputStream(), new PrintStream(cpanel.getConsole().getOutputStream()));
    StreamGobbler pErr = new StreamGobbler(p.getErrorStream(), new PrintStream(cpanel.getConsole().getOutputStream()));
    pOut.start();
    pErr.start();
}
catch(IOException ioe)
{
    JOptionPane.showMessageDialog(null,
        "There was a system error invoking this program.",
        "ERROR",
        JOptionPane.ERROR_MESSAGE);
}