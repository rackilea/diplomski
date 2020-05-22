public static String httpPostMultipartFile(String url, File file) throws IOException{
   RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<String, Object>();     
        multipartMap.add("file", new FileSystemResource(file.getPath()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<Object> request = new HttpEntity<Object>(multipartMap, headers);         
        String result = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                String.class
            ).getBody();

        return result;
}