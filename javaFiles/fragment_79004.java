private final List<MethodInterceptor> PROJECT_CHECK_METHOD_LIST;

@Inject
public HK2InterceptorFilter(ServiceLocator locator) {
    final MethodIntercator i = new ProjectOwnerCheckInterceptor();
    locator.inject(i)
    PROJECT_CHECK_METHOD_LIST = Collections.singletonList(i);
}