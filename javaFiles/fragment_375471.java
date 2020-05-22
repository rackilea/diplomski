final String urlWs = "https://user:pass@foobarbaz.com";
final HttpHeaders headers = new HttpHeaders();
final String pattern = "^(?<protocol>.+?//)(?<username>.+?):(?<password>.+?)@(?<address>.+)$";
final Pattern regExpPattern = Pattern.compile(pattern);
final Matcher matcher = regExpPattern.matcher(urlWs);
if(matcher.find()) {
   final String username = matcher.group("username");
   final String password = matcher.group("password");
   final String plainCreds = username + ":" + password;
   final byte[] plainCredsBytes = plainCreds.getBytes();
   final byte[] base64CredsBytes = Base64Utils.encode(plainCredsBytes);
   final String base64Creds = new String(base64CredsBytes);
   headers.add("Authorization", "Basic " + base64Creds);
}
final HttpEntity<String> request = new HttpEntity<String>(headers);
final RestTemplate restTemplate = new RestTemplate();
final ResponseEntity<String> wsCalendarResponse = restTemplate.exchange(urlWs, HttpMethod.GET, request, String.class);