public class LinkedTemplate extends AbstractOAuth2ApiBinding {
    private String accessToken;

    public LinkedTemplate() {
    }

    public LinkedTemplate(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
    }

    class ExcelConverter extends ByteArrayHttpMessageConverter {
        public ExcelConverter() {
            MediaType t = new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            this.setSupportedMediaTypes(Arrays.asList(t));
        }
    }

    public void downloadLinkedFile(final String url, final String outputPath) throws IOException {
        //application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
        RestTemplate template = getRestTemplate();
        template.setMessageConverters(Arrays.asList(new ExcelConverter()));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType("application")));

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<byte[]> response = template.exchange(
                url,
                HttpMethod.GET, entity, byte[].class, "1");

        if (response.getStatusCode() == HttpStatus.OK) {
            Files.write(Paths.get(outputPath), response.getBody());
        }
    }
}