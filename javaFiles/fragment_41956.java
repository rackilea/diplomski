private static final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:23.0) Gecko/20100101 Firefox/23.0";

HttpURLConnection lConn = (HttpURLConnection) argv[0].openConnection();
lConn.setRequestProperty("User-Agent", USER_AGENT);
lConn.connect();
lNode = cleaner.clean( lConn.getInputStream() );