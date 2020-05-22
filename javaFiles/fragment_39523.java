final URL website = new URL("http://your.url.here"); // The website you want to connect

// -- Setup connection through proxy
Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("<proxyserver>", 1234)); // set proxy server and port
HttpURLConnection httpUrlConnetion = (HttpURLConnection) website.openConnection(proxy);
httpUrlConnetion.connect();

// -- Download the website into a buffer
BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConnetion.getInputStream()));
StringBuilder buffer = new StringBuilder();
String str;

while( (str = br.readLine()) != null )
{
    buffer.append(str);
}

// -- Parse the buffer with Jsoup
Document doc = Jsoup.parse(buffer.toString());