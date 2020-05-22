public class MyProvider extends PerRequestTypeInjectableProvider<Context, DataType> {
    @Context UriInfo uriInfo;

    public Injectable<DataType> getInjectable(ComponentContext componentCtx, Context ctx) {
        uri.getPathSegments();
        ...
    }
}