String[] urls = {"localhost:8080/myapp",
                     "https://myapp-dev.myhost.com/app/test.pdf",
                     "http://myapp-dev.host.com/app/", 
                     "http://app.host.com:8080/app/app2"};

    for(String url : urls){
        String s = url.replaceAll("/$", "").replaceAll("/[^/]+$", "/");
        System.out.println(url);
        System.out.println(s); 
        System.out.println();
    }