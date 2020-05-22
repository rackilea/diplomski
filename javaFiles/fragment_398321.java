PrintWriter pw = null;

Process proc = Runtime.getRuntime().exec(externalProgram);

InputStreamReader isr = new InputStreamReader(proc.getErrorStream());
BufferedReader br = new BufferedReader(isr);
String line;
while ( (line = br.readLine()) != null)
{
   if (pw == null)
   {
      pw = new PrintWriter(new FileOutputStream(logFile));
   }
   pw.println(line);
   pw.flush(); 
}