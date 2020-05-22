public void sendFile throws IOException {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod("http://yourserverip:8080/yourServlet");

        File f = new File(destFileName);

        postMethod.setRequestBody(new FileInputStream(f));
        postMethod.setRequestHeader("Content-type",
            "text/xml; charset=ISO-8859-1");

        client.executeMethod(postMethod);
        postMethod.releaseConnection();
    }