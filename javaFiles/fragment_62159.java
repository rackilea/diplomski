KieServices ks = KieServices.Factory.get();
KieRepository kr = ks.getRepository();
KieFileSystem kfs = ks.newKieFileSystem();
File file = new File("path/to/drl");
kfs.write(ks.getResources().newFileSystemResource(file)
              .setResourceType(ResourceType.DRL));
KieBuilder kb = ks.newKieBuilder(kfs);
kb.buildAll(); 
if (kb.getResults().hasMessages(Level.ERROR)) {
    throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
}
KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
KieSession kSession = kContainer.newKieSession();
kSession.insert(fact);
kSession.fireAllRules();