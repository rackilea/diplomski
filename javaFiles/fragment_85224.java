@Repository
public class ExternalServiceRepository {

    private static ConcurrentHashMap<String, OAuth2RestTemplate> restTemplates = new ConcurrentHashMap<>();

    /**
     * Get a RestTemplate for a specific client based on it's client secret id.
     * Create one if it hasn't been initialized yet.
     */
    public OAuth2RestTemplate restTemplate(String clientKey) {

        synchronized (restTemplates) {
            OAuth2RestTemplate restTemplate = restTemplates.get(clientKey);

            if (restTemplate == null) {
                ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
                details.setAccessTokenUri("https://external-service.example.com/OAuth/Token");
                details.setClientId("abcdefghijklmnopq");
                details.setClientSecret(clientKey);
                details.setGrantType("client_credentials");

                restTemplate = new OAuth2RestTemplate(details, new DefaultOAuth2ClientContext());
                restTemplates.put(clientKey, restTemplate);
            }

            return restTemplate;
        }
    }
}