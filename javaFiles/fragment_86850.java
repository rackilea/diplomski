MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
body.add("key", "XXX");
body.add("nonce", "XX");
body.add("signature", "XX");

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

HttpEntity<?> requestEntity = new HttpEntity<Object>(body, headers);

ResponseEntity<AccountBalance> responseEntity = restTemplate.exchange(bitstampBalanceUrl, HttpMethod.POST,
                requestEntity, AccountBalance.class);