private void initializeInjector() {
    FeedsCatalogActivityComponent feedsCatalogActivityComponent = DaggerFeedsCatalogActivityComponent.builder()
            .feederApplicationComponent(feederApplicationComponent()/* create this method and it should return a correctly built  FeederApplicationComponent */ )
            .feedsCatalogActivityModule(
                new FeedsCatalogActivityModule(
                    new SelectedInterfaceListener() 
                    /* pass in the instance of SelectedInterfaceListener here */ )
                ).build(); 
}