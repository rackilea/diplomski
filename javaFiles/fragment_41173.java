URL url = new URL("file:///test/test.properties");

URLConnection con = url.openConnection();
ResourceUtils.useCachesIfNecessary(con);

InputStream stream = con.getInputStream();