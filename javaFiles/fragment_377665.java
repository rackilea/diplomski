HttpClient httpClient = new HttpClient();       
    PostMethod method = new PostMethod(url);        
    String badFormPost = "[SORT]=0,1,0,10,5,0,KL,0&[FIELD]=33,38,51,58,68,88,78,98,99,101,56,57,69,70,71,72,89,90,91,92,59,60,61,62,79,80,81,82&[LIST]=1155.KL,1295.KL,7191.KL,0097.KL,2267.KL";
    RequestEntity entity = new StringRequestEntity(badFormPost, 
            "application/x-www-form-urlencoded", "UTF-8");
    method.setRequestEntity(entity);
    method.setContentChunked(false);
    httpClient.executeMethod(method);
            ...