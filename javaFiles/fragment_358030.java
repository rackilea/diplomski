public static String uploadFile()
     {
         String myApiKey="apikey";
         String uploadFileName="/path/to/file.ext";
         String HOST="http://ckan.host.com";
         String line;
         StringBuilder sb = new StringBuilder();
         CloseableHttpClient httpclient = HttpClientBuilder.create().build();
         File file = new File(uploadFileName);   
         SimpleDateFormat dateFormatGmt = new  SimpleDateFormat("yyyyMMdd_HHmmss");
         String date=dateFormatGmt.format(new Date()); 

         HttpPost postRequest;
         file = new File(uploadFileName);
         try {

           ContentBody cbFile = new FileBody(file, ContentType.TEXT_HTML);
           HttpEntity reqEntity = MultipartEntityBuilder.create()
            .addPart("file", cbFile)
            .addPart("key", new StringBody(uploadFileName+date,ContentType.TEXT_PLAIN))
            .addPart("package_id",new StringBody("dataSetName",ContentType.TEXT_PLAIN))
            .addPart("url",new StringBody("path/to/save/dir",ContentType.TEXT_PLAIN))
            .addPart("upload",cbFile)
            .addPart("comment",new StringBody("comments",ContentType.TEXT_PLAIN))
            .addPart("notes", new StringBody("notes",ContentType.TEXT_PLAIN))
            .addPart("author",new StringBody("AuthorName",ContentType.TEXT_PLAIN))
            .addPart("author_email",new StringBody("AuthorEmail",ContentType.TEXT_PLAIN))
            .addPart("title",new StringBody("title",ContentType.TEXT_PLAIN))
            .addPart("description",new StringBody("file Desc"+date,ContentType.TEXT_PLAIN))       
            .build();

           postRequest = new HttpPost(HOST+"/api/action/resource_create");
                postRequest.setEntity(reqEntity);
                postRequest.setHeader("X-CKAN-API-Key", myApiKey);

           HttpResponse response = httpclient.execute(postRequest);
           int statusCode = response.getStatusLine().getStatusCode();
           BufferedReader br = new BufferedReader(
                   new InputStreamReader((response.getEntity().getContent())));

           sb.append(statusCode+"\n");
           if(statusCode!=200){
              System.out.println("statusCode =!=" +statusCode);           
           }
           else System.out.println("OK"); 

            while ((line = br.readLine()) != null) {
               sb.append(line+"\n");
             System.out.println("+"+line);
           }

           httpclient.close();
           return sb.toString();
    }catch (IOException ioe) {
    System.out.println(ioe);
    return "error"+ioe;
    } finally {
    httpclient.getConnectionManager().shutdown();

    }
}