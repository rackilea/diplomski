HttpEntity entity = response.getEntity();
if (entity != null) {
    InputStream instream = entity.getContent();

    String result = RestClient.convertStreamToString(instream);        
}