import java.net.Proxy;
import java.net.ProxySelector;

//setting Application-Wide proxy Values
private void setProxy() {
    //Device proxy settings
    ProxySelector defaultProxySelector = ProxySelector.getDefault();
    Proxy proxy = null;
    List<Proxy> proxyList = defaultProxySelector.select(URI.create("http://www.google.in"));
    if (proxyList.size() > 0) {
        proxy = proxyList.get(0);

        Log.d("proxy", String.valueOf(proxy));

        try {
            String proxyType = String.valueOf(proxy.type());

            //setting HTTP Proxy
            if (proxyType.equals("HTTP")) {
                String proxyAddress = String.valueOf(proxy.address());
                String[] proxyDetails = proxyAddress.split(":");
                String proxyHost = proxyDetails[0];
                String proxyPort = proxyDetails[1];
                Log.d("proxy", proxyType + " " + proxyHost + " " + proxyPort);

                System.setProperty("http.proxyHost", proxyHost);
                System.setProperty("http.proxyPort", proxyPort);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}