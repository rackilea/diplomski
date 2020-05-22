XComponentContext context = Bootstrap.bootstrap();
  XMultiComponentFactory factory =
        context.getServiceManager();
  Object dispatchHelperObject = factory.createInstanceWithContext(
        "com.sun.star.frame.DispatchHelper", ooContext);
  this.dispatchHelper = (XDispatchHelper)UnoRuntime.queryInterface(
        XDispatchHelper.class, dispatchHelperObject);