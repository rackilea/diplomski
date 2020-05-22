Reader fileReader = null;

InputStream is = this.getClass().getResourceAsStream("/test.xml");
if (null != is) {
    fileReader = new InputStreamReader(is);
}