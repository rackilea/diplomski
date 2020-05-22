// create the Map of the MultiValueMap
MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
map.add("grant_type", "password");
map.add("client_id", "XX");
map.add("client_secret", "XXX");
map.add("username", "XX");
map.add("password", "XXX");

// RestTemplate
RestTemplate restTemplate = new RestTemplate();
Map<String, String> token = restTemplate.postForObject(TOKEN_URL, map, Map.class);
System.out.println("--------------------------------------------");
System.out.println("Access Token  :: "+token.get("access_token"));
System.out.println("Instance Url  :: "+token.get("instance_url"));
System.out.println("Id  :: "+token.get("id"));
System.out.println("Token_Type  :: "+token.get("token_type"));
System.out.println("Signature  :: "+token.get("signature"));
System.out.println("--------------------------------------------");