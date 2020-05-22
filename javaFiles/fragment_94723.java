public void sendOTP() {
    RestTemplate restTemplate = new RestTemplate();

    String message = "Your PIN for account verification is 123456";
    String user = "******405e4c****19d0******";
    String password = "******";
    String smsurl = "https://api.twilio.com/2010-04-01/Accounts/"+user+"/Messages.json";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("From", "+1334384****");
    map.add("To", "+999999999");
    map.add("Body", message);

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);

    try {
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, password));
        Object response = restTemplate.postForObject(smsurl, httpEntity, Object.class);
        LOG.info("Sms Response: {}", gson.toJson(response));
    } catch(Exception e) {
        LOG.error(e.getMessage());
    }
}