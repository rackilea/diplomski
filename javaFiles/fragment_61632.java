@NoCache
@Provider
public class NoCacheFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, 
                       ContainerResponseContext response) {

        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoStore(true);
        cacheControl.setNoCache(true);
        cacheControl.setMustRevalidate(true);
        cacheControl.setProxyRevalidate(true);
        cacheControl.setMaxAge(0);
        cacheControl.setSMaxAge(0);

        response.getHeaders().add(HttpHeaders.CACHE_CONTROL, cacheControl.toString());
        response.getHeaders().add(HttpHeaders.EXPIRES, 0);
    }
}