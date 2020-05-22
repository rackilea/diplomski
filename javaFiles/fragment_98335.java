public void build() throws Exception {
    KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kfs = kieServices.newKieFileSystem();
    //...
    Resource res = ...; 
    kfs.write( "src/main/resources/simple.drl", res );
    KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
    Results results = kieBuilder.getResults();
    if( results.hasMessages( Message.Level.ERROR ) ){
        System.out.println( results.getMessages() );
        throw new IllegalStateException( "### errors ###" );
    }

    KieContainer kieContainer =
        kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );

    KieBase kieBase = kieContainer.getKieBase();
    kieSession = kieBase.newKieSession();
}