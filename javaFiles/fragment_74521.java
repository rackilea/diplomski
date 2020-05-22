public class TestServlet extends SlingAllMethodsServlet {

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    protected void doPost(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException, IOException {

        final Map<String, Object> authenticationInfo = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, "testservlet");
        try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(authenticationInfo)) {

            Resource rootRes = resolver.getResource("/content/....");
            resolver.create(rootRes, "test", null);
            resolver.commit();

        } catch (Exception e) {
            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(response.getWriter());
        }
    }
}