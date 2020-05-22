RestTemplate rt = new RestTemplate();

// Create a multimap to hold the named parameters
MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();
parameters.add("username", marshalRequest(usernameObj));
parameters.add("password", marshalRequest(passwordObj));

// Create the http entity for the request
HttpEntity<MultiValueMap<String,String>> entity =
            new HttpEntity<MultiValueMap<String, String>>(parameters, headers);

// Get the response as a string
String response = rt.postForObject(endpoint, entity, String.class);

// Unmarshal the response back to the expected object
MyReturnObj obj = (MyReturnObj) unmarshalResponse(response);