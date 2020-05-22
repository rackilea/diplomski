public class CorsNoopHandlerMapping extends RequestMappingHandlerMapping {

    public CorsNoopHandlerMapping() {
        setOrder(0);  // Make it override the default handler mapping.
    }

    @Override
    protected HandlerExecutionChain getCorsHandlerExecutionChain(HttpServletRequest request,
             HandlerExecutionChain chain, CorsConfiguration config) {
        return chain;  // Return the same chain it uses for everything else.
    }
}