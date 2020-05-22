List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<byte[]> result = restTemplate.exchange( "someurl deleted On purpose",
                                                               HttpMethod.GET,
                                                               httpEntity,
                                                               byte[].class );

        ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(result.getBody()));
        ZipEntry entry = null;
        while ((entry = zipStream.getNextEntry()) != null)
        {
            System.out.println( "entry: " + entry );
        }