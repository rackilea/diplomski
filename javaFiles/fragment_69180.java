ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
WifiManager wm = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);

WifiInfo connectionInfo = wm.getConnectionInfo();
int ipAddress = connectionInfo.getIpAddress();
String ipString = Formatter.formatIpAddress(ipAddress);