String url = "http://example.com/search";
MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
params.add("name", "john");
params.add("location", "africa");

UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).queryParams(params).build();
System.out.println(uriComponents.toUri());