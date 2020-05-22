restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

Map params = new LinkedMultiValueMap();
params.add("file", new FileSystemResource(file));
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
HttpEntity requestEntity = new HttpEntity<>(params, httpHeaders);
restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);