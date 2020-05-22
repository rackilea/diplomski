@Override
protected void configure(){
    install(new FactoryModuleBuilder()
            .implement(IPagingDirectoryViewController.class, PagingDirectoryViewController.class)
            .build(IPagingDirectoryControllerFactory.class));
}