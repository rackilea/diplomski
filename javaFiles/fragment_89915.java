public Downloader(String path) throws IOException {
    int len = 0;
    URL url = new URL(path);
    URLConnection connectUrl = url.openConnection();
    System.out.println(len = connectUrl.getContentLength());
    System.out.println(connectUrl.getContentType());

    InputStream input = connectUrl.getInputStream();
    int i = len;
    int c = 0;
    System.out.println("=== Content ==="); 
    while (((c = input.read()) != -1) && (--i > 0)) {
        System.out.print((char) c);
    }
    input.close(); 
}