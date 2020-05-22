@PreMatching
public class XSSFilter implements ContainerRequestFilter
{
    /**
     * @see ContainerRequestFilter#filter(ContainerRequest)
     */
    @Override
    public void filter( ContainerRequestContext request )
    {
        cleanQueryParams( request );
        cleanHeaders( request.getHeaders() );
    }


    /**
     * Replace the existing query parameters with ones stripped of XSS vulnerabilities
     * @param request
     */
    private void cleanQueryParams( ContainerRequestContext request )
    {
        UriBuilder builder = request.getUriInfo().getRequestUriBuilder();
        MultivaluedMap<String, String> queries = request.getUriInfo().getQueryParameters();

        for( Map.Entry<String, List<String>> query : queries.entrySet() )
        {
            String key = query.getKey();
            List<String> values = query.getValue();

            builder.replaceQueryParam( key );
            for( String value : values ) {
                builder.replaceQueryParam( key, Utils.stripXSS( value ) );
            }

        }

        request.setRequestUri( builder.build() );
    }


    /**
     * Replace the existing headers with ones stripped of XSS vulnerabilities
     * @param headers
     */
    private void cleanHeaders( MultivaluedMap<String, String> headers )
    {
        for( Map.Entry<String, List<String>> header : headers.entrySet() )
        {
            String key = header.getKey();
            List<String> values = header.getValue();

            List<String> cleanValues = new ArrayList<String>();
            for( String value : values ) {
                cleanValues.add( Utils.stripXSS( value ) );
            }

            headers.put( key, cleanValues );
        }
    }
}