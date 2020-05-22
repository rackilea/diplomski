@BeforeClass
public void setProxy() 
{
System.setProperty("http.proxyHost", YOUR_PROXY_HOST_HERE);
System.setProperty("http.proxyPort", YOUR_PROXY_PORT_HERE);
}