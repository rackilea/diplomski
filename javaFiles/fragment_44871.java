@Autowired
DataSource dataSource;

@Override
public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.jdbc(dataSource); // Get clients from database, table = oauth_client_details
}