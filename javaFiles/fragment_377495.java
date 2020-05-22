public static void main(String[] args)
{   
    String s = "No.\",\"Time\",\"Source\",\"Destination\",\"Protocol\",\"Length\",\"Info\",\"SrcPort\",\"Dest.port\",\"Response time\",\"Frequency\",\"delta\",\"2007-11-13 18:10:53.940873\",\"127.0.0.1\",\"127.0.0.1\",\"HTTP\",\"162\",\"GET /scripts/..%25%35%63../winnt/system32/cmd.exe?/c+dir HTTP/1.0 \",\"43974\",\"80\",\"0.000000\",\"\",\"0.000000";
    Matcher m = Pattern.compile("(?m)(?<IP>\(\\d){3}\\.(\\d\\.){2}\\d\).*?(?<METHOD>GET|POST|PUT|DELETE)(?<URI>.*?(?<HTTPVERSION>HTTP\\/\\d(\\.\\d)?))").matcher(s);
    m.find();
    System.out.println("Result " + m.group("IP") + " " + m.group("METHOD") + " " + m.group("URI") + " " + m.group("HTTPVERSION"));
}