public class CsvMessageConverter extends AbstractHttpMessageConverter<CsvResponse> {
   public static final MediaType MEDIA_TYPE = new MediaType("text", "csv", Charset.forName("utf-8"));
   public CsvMessageConverter() {
       super(MEDIA_TYPE);
   }

   protected boolean supports(Class<?> clazz) {
       return CsvResponse.class.equals(clazz);
   }

   protected void writeInternal(CsvResponse response, HttpOutputMessage output) throws IOException, HttpMessageNotWritableException {
       output.getHeaders().setContentType(MEDIA_TYPE);
       output.getHeaders().set("Content-Disposition", "attachment; filename=\"" + response.getFilename() + "\"");
       OutputStream out = output.getBody();
       CsvWriter writer = new CsvWriter(new OutputStreamWriter(out), '\u0009');
       List<CompositeRequirement> allRecords = response.getRecords();
       for (int i = 1; i < allRecords.size(); i++) {
            CompositeRequirement aReq = allRecords.get(i);
            writer.write(aReq.toString());
       }
       writer.close();
   }
}