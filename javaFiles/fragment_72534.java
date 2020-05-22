@GetMapping("/spotify-response")
public void spotifyResponse(@RequestParam String code, HttpServletResponse httpServletResponse) {
    String _clientId = "5eb8ce6ea7d04*******e870c48f";
    String _clientSecret = "d45470deea224********3d8ab9";
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    String usernamePassword = _clientId+":"+_clientSecret;
    String basicToken = Base64.getEncoder().encodeToString(usernamePassword.getBytes());
    httpHeaders.set("Authorization", "Basic "+basicToken);

    MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
    requestBody.add("grant_type", "authorization_code");
    requestBody.add("code", code.trim());
    requestBody.add("redirect_uri", "http://localhost:11001/api/spotify-response");

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
    try {
        Object response = restTemplate.postForObject("https://accounts.spotify.com/api/token", httpEntity, Object.class);
        Map<String, Object> map = (Map<String, Object>) response;
        map.forEach((k, v) -> System.out.println(k+": "+v));
        httpServletResponse.setStatus(302);
        String accessToken = (String) map.get("access_token");
        String patientId = (String) map.get("patient");
        String url = "http://localhost:4200/login-success?accessToken="+accessToken+"&patientId="+patientId;
        httpServletResponse.setHeader("Location", url); // redirect to success page
    }
    catch(HttpClientErrorException e) {
        e.printStackTrace();
    }
}