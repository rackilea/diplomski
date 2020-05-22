// create the REST template
RestTemplate rest = new RestTemplate()
// add the authorization header
HttpHeaders headers = new HttpHeaders();
headers.add("Authorization", "DEVELOPMENT-Indexer");

// define URL and query
String url = "http://api.exiletools.com/index/_search";
String allQuery = "{\"query\":{\"matchAll\":{}}}";

// make the request
HttpEntity<String> httpReq = new HttpEntity<String>(allQuery, headers);
ResponseEntity<String> resp = rest.exchange(url, HttpMethod.POST, httpReq, String.class)

// retrieve the JSON response
String body = resp.getBody();