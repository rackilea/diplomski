public ResponseEntity<String> postJson(Set<Type> Types){
            try {
                String oneString = String.join(",", Types);
               Map<String, String> requestBody = new HashMap<>();
                requestBody.put("type", oneString);
                JSONObject jsonObject = new JSONObject(requestBody);
                HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), null);
    ResponseEntity result = restTemplate.exchange(url, HttpMethod.POST,
                        new HttpEntity<>(request, getHttpHeaders()), String.class);
                } 
        }
        return Types;