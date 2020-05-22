ArrayList<URL> combinedNewURLs = new ArrayList<>();
combinedNewURLs.addAll(newPU.getJarFileUrls());
combinedNewURLs.add(newPU.getPersistenceUnitRootUrl());
if (!combinedNewURLs.contains(oldPU.getPersistenceUnitRootUrl())){
    // Root url of existing persistenceunit not known in the 
    // new one, add it as jar url.
    newPU.addJarFileUrl(oldPU.getPersistenceUnitRootUrl());
}