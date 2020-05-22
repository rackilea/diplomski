// First set the default cookie manager.
CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

// All the following subsequent URLConnections will use the same cookie manager.
URLConnection connection = new URL(url).openConnection();
// ...

connection = new URL(url).openConnection();
// ...

connection = new URL(url).openConnection();
// ...