Process process = new ProcessBuilder("C:\\PathToExe\\MyExe.exe","param1","param2",).start();
InputStream is = process.getInputStream();//Get an inputstream from the process which is being executed
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String line;
while ((line = br.readLine()) != null) {
System.out.println(line);//Prints all the outputs.Which is coming from the executed Process
}