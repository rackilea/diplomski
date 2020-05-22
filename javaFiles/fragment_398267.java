public class RestyDispatcher extends DefaultFilterawareDispatcher {

    @Inject
    public RestyDispatcher(ForbiddenDispatcherFilter filter) {
      addFilter(filter);
      addFilter(new BasicAuthHeaderDispatcherFilter());
    }

    @Override
    public Request send(Method method, RequestBuilder builder) throws RequestException {
      return super.send(method, builder);
    }
}