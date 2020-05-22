//ProcessBuilder is the recommended way of creating processes since Java 1.5 
//Runtime.getRuntime().exec() is deprecated. Do not use. 
ProcessBuilder pb = new ProcessBuilder("wkhtmltopdf.exe", htmlFilePath, pdfFilePath);
Process process = pb.start();

BufferedReader errStreamReader = new BufferedReader(new  InputStreamReader(process.getErrorStream())); 
//not "process.getInputStream()" 
String line = errStreamReader.readLine(); 
while(line != null) 
{ 
    System.out.println(line); //or whatever else
    line = reader.readLine(); 
}