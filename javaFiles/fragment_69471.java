KieServices kieServices = KieServices.Factory.get();
KieFileSystem kfs = kieServices.newKieFileSystem();

File file = new File("path/to/Rule.drl");
org.kie.api.io.Resource resource = kieServices.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
kfs.write(resource);

KieBuilder Kiebuilder = kieServices.newKieBuilder(kfs);
Kiebuilder.buildAll();
KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
KieSession ksession = kieContainer.newKieSession();