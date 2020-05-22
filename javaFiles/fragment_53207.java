return restTemplate.execute(new URI("http://<myservice>/upload/" + importId), HttpMethod.GET, null,
            new ResponseExtractor<MyObject>() {
                @Override
                public MyObject extractData(ClientHttpResponse response) throws IOException {
                    CSVParser parse = CSVFormat.DEFAULT.parse(new BufferedReader(new InputStreamReader(response.getBody())));
                    for (CSVRecord record : parse) {/*dostuff*/}
                    return new MyObject();
                }
            });