public static String post(String url,String[] args) throws UnsupportedEncodingException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpPost httpPost = new HttpPost(url);

        FileBody bin = new FileBody(new File(args[0]));//"/sdcard/DCIM/cam.jpg"));//
        long size = bin.getContentLength();

        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("image1", bin);
        String content = "-";
        try {
             httpPost.setEntity(reqEntity);
                HttpResponse response = httpClient.execute(httpPost, localContext);
                HttpEntity ent = response.getEntity();
                InputStream st = ent.getContent();
                StringWriter writer = new StringWriter();
                IOUtils.copy(st, writer);
                content = writer.toString();                

        } catch (IOException e) {                   
            return "false";
        }
        return content;
    }