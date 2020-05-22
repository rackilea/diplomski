@SuppressWarnings("unchecked")
private void findRouteClasses() {
    final Set<Class<?>> routeClasses = ReflectionUtils.findClassesWithAnnotation(Route.class,
    "com.example.myproject");

    this.routeClasses = new HashSet<>();

    for (final Class<?> clazz : routeClasses)
        this.routeClasses.add((Class<? extends Component>) clazz);
}

@Override
protected void servletInitialized() throws ServletException {
    final ServletContext context = getServletContext();
    final Object routeRegistryObject = context.getAttribute(RouteRegistry.class.getName());

    if (routeRegistryObject == null)
        throw new ServletException("routeRegistryObject is null");

    if ((routeRegistryObject instanceof RouteRegistry) == false)
        throw new ServletException("routeRegistryObject is not of type RouteRegistry");

    final RouteRegistry routeRegistry = (RouteRegistry) routeRegistryObject;
    findRouteClasses();

    try {
        routeRegistry.setNavigationTargets(routeClasses);
    } catch (final InvalidRouteConfigurationException e) {
        throw new ServletException(e);
    }

    super.servletInitialized();
}