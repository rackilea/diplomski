URL myUrl = getURLToLoad();
URLConnection con = myUrl.openConnection()
con.setConnectTimeout(1000);
con.setReadTimeout(2000);
InputStream in = con.getInputStream();
// parse in however you want