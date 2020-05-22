FileInputStream fis1 = new FileInputStream( "simple/simple.dsl" );
kfs.write( "src/main/resources/simple.dsl",
           kieServices.getResources().newInputStreamResource( fis1 ) );
FileInputStream fis2 = new FileInputStream( "simple/simple.dslr" );
kfs.write( "src/main/resources/simple.dslr",
           kieServices.getResources().newInputStreamResource( fis2 ) );
KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();