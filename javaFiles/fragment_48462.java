public static void main(String[] args) throws Exception {
    String s = "<br/><description>Using a combination of remote probes, (TCP/IP, SMB, HTTP, NTP, SNMP, etc...) it is possible to guess the name of the remote operating system in use, and sometimes its version.</description><br/><fname>os_fingerprint.nasl</fname><br/><plugin_modification_date>2012/12/01</plugin_modification_date><br/><plugin_name>OS Identification</plugin_name><br/><plugin_publication_date>2003/12/09</plugin_publication_date><br/><plugin_type>combined</plugin_type><br/><risk_factor>None</risk_factor><br/><solution>n/a</solution><br/><synopsis>It is possible to guess the remote operating system.</synopsis><br/><plugin_output><br/>Remote operating system : Microsoft Windows Server 2008 R2 Enterprise Service Pack 1<br/>Confidence Level : 99<br/>Method : MSRPC<br/><br/> <br/>The remote host is running Microsoft Windows Server 2008 R2 Enterprise Service Pack 1</plugin_output><br/>";

    Pattern pattern = Pattern.compile(".*Remote operating system : (.*?)<br/>");
    Matcher m = pattern.matcher(s);
    if (m.find()) {
      System.out.println(m.group(1));
    }
    else System.out.println("Not found");
}