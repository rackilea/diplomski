/**
 * Provides methods for making requests to the API interface.
 * 
 *
 */
public class RestClientApiUtil {

    public RestClientApiUtil() {
    }


    private String apiUsername;

    /**
     * The password for accessing the external API interface.
     */
    private String apiPassword;

    /**
     * The base URL for accessing the external API  interface.
     */
    private String apiUrl;


    public RestClientApiUtil(String apiUsername, 
            String apiPassword, String apiUrl) {
        this.apiUsername = apiUsername;
        this.apiPassword = apiPassword;
        this.apiUrl = apiUrl;
    }

    /**
     * Makes a call to the external API interface and returns the response received.
     * @param requestData the request data to attach in the request body
     * @param endpoint the specific endpoint to make a request to
     * @param clazz the class in which the response is expected
     * @return Object
     * @throws Exception
     */
    public <T> T callService(Object requestData, String endpoint, Class<T> clazz)
            throws TechnicalException {


        RestTemplate restTemplate = null;
        ResponseEntity<?> responseEntity = null;
        String webServiceUrl = "";
        HttpEntity<Object> requestBody = null;
        try {
            webServiceUrl = formServiceUrl(this.apiUrl, endpoint);
            requestBody = createRequestBody(requestData);
            restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(webServiceUrl, HttpMethod.POST, requestBody, clazz);
            return clazz.cast(responseEntity.getBody());
        } catch (Exception e) {
            throw new Exception(e);
        } 
    }

}