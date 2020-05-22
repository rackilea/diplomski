public class CustomRouter extends InternalRouter {
    public CustomRouter(Context context) {
        super(context);
        setFinderClass(CustomFinder.class);
    }

    protected TemplateRoute createRoute(String uriPattern,
                Restlet target, int matchingMode) {
        CustomTemplateRoute result = new CustomTemplateRoute(
                                    this, uriPattern, target);

        result.getTemplate().setMatchingMode(matchingMode);
        result.setMatchingQuery(getDefaultMatchingQuery());
        return result;
    }
}