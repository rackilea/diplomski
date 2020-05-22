String drl = "...";
KieServices kieServices = KieServices.Factory.get();
KieFileSystem kfs = kieServices.newKieFileSystem();
kfs.write( "src/main/resources/simple.drl",
    kieServices.getResources().newReaderResource( new StringReader(drl) ) );
KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();