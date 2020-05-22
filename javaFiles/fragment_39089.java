Hashtable<String, Object> env = new Hashtable<String, Object>();
env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
env.put("java.naming.provider.url",    "dns://<your DNS server>");

DirContext ictx = new InitialDirContext(env);
Attributes attrs = ictx.getAttributes("www.heise.de", new String[] {"A", "AAAA"});

NamingEnumeration<? extends Attribute> e = attrs.getAll();
while(e.hasMoreElements()) {
    Attribute a = e.next();
    System.out.println(a.getID() + " = " + a.get());
}