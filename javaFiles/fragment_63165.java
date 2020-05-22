@Component
public class PathConfigFilter extends ZuulFilter {

    @Autowired
    private ZuulProperties zuulProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getFilterExecutionSummary().toString()
            .contains( "PreDecorationFilter[SUCCESS]" );
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();

        String originalRequestPath = (String) context.get(FilterConstants.REQUEST_URI_KEY);

        //PathVariable change
        URL routeHost = (URL) context.get( "routeHost");
        String modifiedPathVariable = processPathVariableRoutes( routeHost.getPath(), originalRequestPath );
        if(modifiedPathVariable != null){
            try {
                URL newUrl = new URL(routeHost,modifiedPathVariable);
                context.put("routeHost", newUrl);
            } catch (MalformedURLException e) {
                throw new ApiGatewayException( ApiGatewayErrorCodes.PATH_VARIABLE_ERROR );
            }
        }

        //Delete the path because the full path is defined in properties
        context.put(FilterConstants.REQUEST_URI_KEY, "");

        return null;
    }

    private String processPathVariableRoutes(String routeHost, String requestPath){

        if(!routeHost.contains( "*" )){
            return null;
        }

        ArrayList<String> splitedRoute = new ArrayList<>(Arrays.asList(routeHost.split( "/" )));
        splitedRoute.remove( 0 );
        String context = "/" + splitedRoute.get( 0 );
        String realPath = context + requestPath;

        return realPath;
    }
}