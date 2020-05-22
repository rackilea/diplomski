@SlingFilter(scope = SlingFilterScope.COMPONENT, order = Integer.MIN_VALUE)
public class SampleFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(SampleFilter.class);

@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;
        Resource res = slingRequest.getResource();
        if (!(res == null || ResourceUtil.isNonExistingResource(res))) {
            LOG.error("this servlet is called before resource {} at path {}", res.getName(),res.getPath());
        }
        chain.doFilter(request, response);
    }

}