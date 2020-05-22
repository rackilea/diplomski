String url = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q={query}";

// Create a new RestTemplate instance
RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
String result = restTemplate.getForObject(url, String.class, "SpringSource");