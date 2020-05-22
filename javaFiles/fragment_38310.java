ClientEndpointConfig.Configurator configurator = new ClientEndpointConfig.Configurator() {
             public void beforeRequest(Map<String, List<String>> headers) {
          String credentials = "username:password";
          headers.put("Authorization", Arrays.asList("Basic " + new BASE64Encoder().encode(credentials.getBytes())));
                 System.out.println("Header set successfully");
             }
         };

         ClientEndpointConfig clientConfig = ClientEndpointConfig.Builder.create()
                 .configurator(configurator)
                 .build();