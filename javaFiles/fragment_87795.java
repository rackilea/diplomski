FileOutputStream fos = null;
File file = new File("errors.txt");
try 
{
  fos = new FileOutputStream(file);
} 
catch(IOException ioe) 
{
  System.err.println("redirection not possible: "+ioe);
  System.exit(-1);
}
PrintStream ps = new PrintStream(fos);            
((ChannelExec)channel).setErrStream(ps);