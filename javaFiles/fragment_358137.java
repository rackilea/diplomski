RestTemplate rt = new RestTemplate();
    String url = "http://services.groupkt.com/country/get/all";
    ResponseEntity<String> resp = rt.getForEntity(url, String.class);
    assertEquals(resp.getStatusCode(), HttpStatus.OK);
    Gson gson = new GsonBuilder().create();
    Country c = gson.fromJson(resp.getBody(), Country.class);