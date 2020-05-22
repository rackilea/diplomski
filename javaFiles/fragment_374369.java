@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("password"))
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("password", "refresh_token", "id_token");


    }