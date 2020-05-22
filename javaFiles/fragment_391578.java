private JsonParser getResetParser(JsonParser jp) throws IOException {
    JsonFactory factory = jp.getCodec().getFactory();

    StringReader inputSource = (StringReader) jp.getInputSource();
    inputSource.reset();

    BufferedReader br = new BufferedReader(inputSource);
    String source = br.readLine();

    return factory.createJsonParser(source);
}