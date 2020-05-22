@RequestMapping(value = "/redirect", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<?> registerBatchUser(@RequestParam("file") MultipartFile file) {
       if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("D:\\myfileredirect.csv")));
                stream.write(bytes);
                stream.close();


            } catch (Exception e) {
                JwtAuthenticationErrorResponse FeedBackResponse = new JwtAuthenticationErrorResponse();
                FeedBackResponse.setCode(100);
                FeedBackResponse.setMessage(e.getMessage());
                Map<String, Object> FeedBackStatus = new HashMap<String, Object>();
                FeedBackStatus.put("status", FeedBackResponse);
                return ResponseEntity.ok(FeedBackStatus);
            }
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new FileSystemResource("D:\\myfileredirect.csv")); 
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");



        Map<String, Object> FeedBackStatus=new HashMap<String, Object>();
        FeedBackStatus =  restTemplateUserRegitration.exchange("http://localhost:8080/upload",  HttpMethod.POST,  new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), Map.class).getBody();
        return ResponseEntity.ok(FeedBackStatus);

    }