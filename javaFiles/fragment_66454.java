CloseableHttpClient client = HttpClientBuilder.create()
        .setRedirectStrategy(new DefaultRedirectStrategy() {
            @Override
            protected URI createLocationURI(final String location) throws ProtocolException {
                // One can try to rewrite malformed redirect locations 
                //at this point
                return super.createLocationURI(location);
            }
        })
        .build();