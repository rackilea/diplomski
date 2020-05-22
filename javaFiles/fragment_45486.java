@Provider
public class CustomReaderInterceptor implements ReaderInterceptor {

    // Create a Jackson ObjectMapper instance (it can be injected instead)
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
                      throws IOException, WebApplicationException {

        // Parse the request entity into the Jackson tree model
        JsonNode tree = mapper.readTree(context.getInputStream());

        // Extract the values you need from the tree

        // Proceed to the next interceptor in the chain
        return context.proceed();
    }
}