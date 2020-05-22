String data = "/public/"
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);

    HttpEntity<String> request = new HttpEntity<String>(
            data, headers);
    String url = "http://192.168.1.51:8080/pi/FilesServlet";
    restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    String response = restTemplate
            .postForObject(url, request, String.class);