URL url = null;
        URI uri = null;
        String checkUrl = "http://download.microsoft.com/download/6/3/c/63c1d527-9d7e-4fd6-9867-fd0632066740/kinect_qsg%20premium_bndl_en-fr-es.pdf"; 
        try {
            url = new URL(URLDecoder.decode(checkUrl,"UTF-8"));
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        try {
            uri = new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef());
            System.out.println(uri.getHost());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }