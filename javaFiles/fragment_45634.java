public class CustomTemplateRoute extends TemplateRoute {
    public CustomTemplateRoute(Restlet next) {
        super(next);
    }

    public CustomTemplateRoute(Router router,
                  String uriTemplate, Restlet next) {
        super(router, uriTemplate, next);
    }

    public CustomTemplateRoute(Router router,
                  Template template, Restlet next) {
        super(router, template, next);
    }

    @Override
    public float score(Request request, Response response) {
        float result = super.score(request, response);
        (...)
        return result;
    }
}