ManipulateModelhandler man = new ManipulateModelhandler();

    //inject the context into an object
    //IEclipseContext iEclipseContext was injected into this class
    ContextInjectionFactory.inject(man,iEclipseContext);

    man.execute();