List<Hotel> hotels = new ArrayList<>();

ResponseEntity response = Mockito.mock(ResponseEntity.class);
Mockito.when(response.getStatusCode()).thenReturn(HttpStatus.OK);
Mockito.when(response.getBody()).thenReturn(hotels);

when(restTemplate.exchange(eq("delivery"), eq(HttpMethod.GET), any(), eq(Object.class)))
    .thenReturn(response);