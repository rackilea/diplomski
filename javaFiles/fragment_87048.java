String OUTPUT_FORMAT = "\ntime_namelookup:    %{time_namelookup}\ntime_connect:  %{time_connect}\ntime_appconnect:  %{time_appconnect}\ntime_pretransfer:  %{time_pretransfer}\ntime_redirect:  %{time_redirect}\ntime_starttransfer:  %{time_starttransfer}\n----------\ntime_total:  %{time_total}\n";
ProcessBuilder pb = new ProcessBuilder(CURL,"-w" ,OUTPUT_FORMAT, "www.yoursite.com");
Process p = pb.start();
InputStream is = p.getInputStream();
BufferedInputStream bis = new BufferedInputStream(is);
Integer i = null;
StringBuilder stringBuilder = new StringBuilder();
while ((i = bis.read()) != -1) {        
    stringBuilder.append((char) i.byteValue());
}
System.out.println(stringBuilder);