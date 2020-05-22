@Test
public void testUpload() {
    LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
    parameters.add("file", new org.springframework.core.io.ClassPathResource("image.jpg"));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);

    ResponseEntity<String> response = testRestTemplate.exchange(UPLOAD, HttpMethod.POST, entity, String.class, "");

    // Expect Ok
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
}