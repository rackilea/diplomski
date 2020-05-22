MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
entity.addPart("content", new InputStreamBody(in, ,mime, name){
     @Override
     public long getContentLength() {
          return length;
     }
});
put.setEntity(entity);

HttpResponse resp = client.execute(put);