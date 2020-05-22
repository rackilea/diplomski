final InputStream responseStream = client.target(url).request().get(InputStream.class);
System.out.println(responseStream.getClass());
StreamingOutput output = new StreamingOutput() {
    @Override
    public void write(OutputStream out) throws IOException, WebApplicationException {  
        int length;
        byte[] buffer = new byte[1024];
        while((length = responseStream.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        out.flush();
        responseStream.close();
    }   
};
return Response.ok(output).header(
        "Content-Disposition", "attachment, filename=\"...\"").build();