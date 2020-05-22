URL aURL = new URL("http://xxxx.websitename.com:1234/aaa/bbb/ccc");

    System.out.println("protocol = " + aURL.getProtocol());
    System.out.println("authority = " + aURL.getAuthority());
    System.out.println("host = " + aURL.getHost());
    System.out.println("port = " + aURL.getPort());
    System.out.println("path = " + aURL.getPath());
    System.out.println("query = " + aURL.getQuery());
    System.out.println("filename = " + aURL.getFile());
    System.out.println("ref = " + aURL.getRef());