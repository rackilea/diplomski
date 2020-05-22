@Test
    public void postTest() throws IOException {
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.header(any(),any())).thenReturn(requestBodySpec);

        when(requestHeadersSpec.header(any(),any())).thenReturn(requestHeadersSpec);

        when(requestBodySpec.accept(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(ArgumentMatchers.<Class<String>>notNull()))
                .thenReturn(Mono.just("resp"));

        Assert.assertNotNull(restClient.post("http://sampleurl",Object.class, Object.class));
    }