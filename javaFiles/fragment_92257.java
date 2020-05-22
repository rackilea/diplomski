private void startConversionPDF(File file) throws IOException {
    if (args == null) {
        throw new IllegalStateException("No conversion arguments set.");
    }

    PDFConvert data = new PDFConvert();
    data.setInput("upload");
    data.setOutputformat("pdf");
    ConverterOptions converteroptions = new ConverterOptions();
    converteroptions.setMargin_top(60);
    converteroptions.setMargin_bottom(60);
    converteroptions.setMargin_left(30);
    converteroptions.setMargin_right(30);
    data.setConverteroptions(converteroptions);

    MultiPart multipart = new FormDataMultiPart()
              .bodyPart(new FormDataBodyPart("json", data, MediaType.APPLICATION_JSON_TYPE))
              .bodyPart(new FileDataBodyPart("file", file));
    root.request(MediaType.APPLICATION_JSON).post(Entity.entity(multipart, multipart.getMediaType()));
}