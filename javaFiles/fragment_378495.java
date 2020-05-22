@RequestMapping("/upload")
public void upload(
    @RequestHeader("Content-Type") String contentType,
    @RequestBody String body)  {

    Converter converter = ConverterFactory.get(contentType);
    MyFormat commonFormat = converter.convert(body);
    doWhateverIMustWith(commonFormat);
}