whenNew(RestTemplate.class).withNoArguments().thenReturn(restTemplate);

responseEntity = new ResponseEntity<>(
            "some response body",
            HttpStatus.OK
    );

when(restTemplate.exchange(Mockito.anyString(),
        Mockito.<HttpMethod> any(),
        Mockito.<HttpEntity<?>> any(),
        Mockito.<Class<Object>> any()))
        .thenReturn(responseEntity);