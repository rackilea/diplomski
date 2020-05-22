public String doPostMultipart(String url, 
                                String filePath, 
                                List<NameValuePair> params,
                                CloudStatusListener listener
                                ) 
                                throws RestHttpException, 
                                        HttpException, 
                                        IOException {

    if (params == null) params = EMPTY_PARAMS;

    HttpPost request = new HttpPost(url);


    MultipartEntity reqEntity = new MultipartEntity();
    if (filePath != null && !filePath.isEmpty()) {
        FileBody bin = new FileBodyCounter(
                                    new File(filePath),
                                    listener,
                                    new FileInputStream(
                                        new File(filePath)
                                        ).available());
        reqEntity.addPart("fileUpload", bin);
    }

    for (NameValuePair kv : params) {
        multipartAddKV(reqEntity, kv.getName(), kv.getValue());
    }

    request.setEntity(reqEntity);

    return execute(request);
}