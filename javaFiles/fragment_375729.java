@Mock
       RestTemplate restTemplate;
           private Poster poster;

          HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), getHttpHeaders());

           ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);

           Mockito.verify(restTemplate, Mockito.times(1)).exchange(Mockito.eq(uri), Mockito.eq(HttpMethod.POST),
                   Mockito.eq(request), Mockito.eq(String.class));

           Assert.assertEquals(result, poster.postJson(mockData));
       }

       HttpHeaders getHttpHeaders() {
           HttpHeaders headers = new HttpHeaders();
           headers.add(// whatever you need to add);
           return headers;
       }
   }