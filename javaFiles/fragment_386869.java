final String url = String.format("%s/api/shop/{id}", Global.webserviceUrl);

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    HttpHeaders headers = new HttpHeaders();
    headers.set("X-TP-DeviceID", Global.deviceID);
    Shop shop= new Shop();
    Map<String, String> param = new HashMap<String, String>();
    param.put("id","10")
    HttpEntity<Shop> requestEntity = new HttpEntity<Shop>(shop, headers);
    HttpEntity<Shop[]> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Shop[].class, param);

    shops = response.getBody();