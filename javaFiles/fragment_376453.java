List<URL> listUrl = new ArrayList<URL>();

Set<Artifact> deps = project.getDependencyArtifacts();
for (Artifact artifact : deps) {
 final URL url = artifact.getFile().toURI().toURL();
 listUrl.add(url);                      
}

newClassLoader = new URLClassLoader(listUrl.toArray(new URL[listUrl.size()]), Thread.currentThread().getContextClassLoader());