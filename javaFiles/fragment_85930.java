NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

Myendpoint.Builder endpointBuilder = new Myendpoint.Builder(
          HTTP_TRANSPORT,
          JSON_FACTORY,
          null);

endpointBuilder.setApplicationName("My App");
Myendpoint endpoint = endpointBuilder.build();
endpoint.getMyEntity(1L).execute();