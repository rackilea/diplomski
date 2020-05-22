public void testMyResource() {
    ClientConfig config = new DefaultClientConfig();
    config.getClasses().add(JacksonJaxbJsonProvider.class);
    config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

    Client c = Client.create(config);

    WebResource resource = c.resource(Main.BASE_URI);
    ClientResponse response = resource.path("account")
            .accept("application/json").get(ClientResponse.class);

    List<Account> accounts
                = response.getEntity(new GenericType<List<Account>>(){});

    StringBuilder builder = new StringBuilder("=== Accounts ===\n");
    for (Account account: accounts) {
        builder.append("Name: ").append(account.getName()).append(", ")
                .append("Type: ").append(account.getType()).append("\n");          
    }
    builder.append("==================");
    System.out.println(builder.toString());    
}