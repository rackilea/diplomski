private static boolean testDNS(String hostname) {
  try
  {
    DNSResolver dnsRes = new DNSResolver(hostname);
    Thread t = new Thread(dnsRes);
    t.start();
    t.join(1000);
    InetAddress inetAddr = dnsRes.get();            
    return inetAddr != null;
  }
  catch(Exception e)
  { 
    return false;
  }
}

private static class DNSResolver implements Runnable {
    private String domain;
    private InetAddress inetAddr;

    public DNSResolver(String domain) {
        this.domain = domain;
    }

    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(domain);
            set(addr);
        } catch (UnknownHostException e) {                
        }
    }

    public synchronized void set(InetAddress inetAddr) {
        this.inetAddr = inetAddr;
    }
    public synchronized InetAddress get() {
        return inetAddr;
    }
}