StreamingOutput output = new StreamingOutput() {
    @Override
    public void write(OutputStream out) {
        thirdPartyApi.downloadFile(.., .., .., out);
    }
}
return Response.ok(output).build();