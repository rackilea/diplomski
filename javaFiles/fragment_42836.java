WhoisClient whois;

whois = new WhoisClient();

try {
  whois.connect(WhoisClient.DEFAULT_HOST);
  System.out.println(whois.query("foobar"));
  whois.disconnect();
} catch(IOException e) {
  System.err.println("Error I/O exception: " + e.getMessage());
  return;
}