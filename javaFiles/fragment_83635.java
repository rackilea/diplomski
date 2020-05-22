String result = restTemplate.execute("url", HttpMethod.GET, null, new HttpMessageConverterExtractor<String> {
        @Override
        public MyEntity extractData(ClientHttpResponse response)
        throws IOException {
            String result = super.extractData(response);
            if (response.getStatusCode() != HttpStatus.OK) {
                // parse message and log only for some error code
                JsonObject errorJson = parse(result);
                log.warn("Got {} status error, with message [{}]", response.getStatusCode(), errorJson.get("warning"));
            } 
            return result;
        }

    });