String bill = "your code";

InputStream br = new ByteArrayInputStream(bill.getBytes());
BufferedReader in = new BufferedReader(new InputStreamReader(br));
String line;
//if you use windows
FileWriter out = new FileWriter("////IP Printer//printer name");
//if you use linux you can try SMB:
while((line = in.readLine()) != null)
{  
    System.out.println("line"+line);
    out.write(line);
    out.write(0x0D);  CR
    out.write('\n');
    writer.println(line);
}
out.close();
in.close();
writer.close();