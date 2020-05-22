//Constants
    @Value("${keycloak.url}")
    private String keycloakUrl;

    @Value("${keycloak.realm}")
    private String keycloakRealm;

    @Value("${keycloak.client_id}")
    private String keycloakClientId;

    RestTemplate restTemplate = new RestTemplate();
    private static final String BEARER = "BEARER ";