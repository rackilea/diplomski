FormBodyPart bodyPart = new FormBodyPart("stuff", new StringBody("stuff", ContentType.DEFAULT_TEXT)) {

    @Override
    protected void generateContentType(ContentBody body) {
    }

};
HttpEntity entity = MultipartEntityBuilder.create().addPart(bodyPart).build();
entity.writeTo(System.out);