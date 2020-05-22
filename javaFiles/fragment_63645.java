JSch jsch = new JSch();
jsch.addIdentity("/path/to/private/key");
Session session = jsch.getSession("user", "host");
ProxyHTTP  proxy = new ProxyHTTP("proxy", proxyport)
proxy.setUserPasswd("proxyusername", "proxypassword");
session.setProxy(proxy);
session.connect();