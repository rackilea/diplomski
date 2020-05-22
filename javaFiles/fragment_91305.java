public static void main(final String[] args) throws Exception {
    DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
    RepositorySystem system = newRepositorySystem(locator);
    RepositorySystemSession session = newSession(system);

    RemoteRepository central = new RemoteRepository.Builder("central", "default", "http://repo1.maven.org/maven2/").build();

    Artifact artifact = new DefaultArtifact("group.id:artifact.id:version");

    CollectRequest collectRequest = new CollectRequest(new Dependency(artifact, JavaScopes.COMPILE), Arrays.asList(central));
    DependencyFilter filter = DependencyFilterUtils.classpathFilter(JavaScopes.COMPILE);
    DependencyRequest request = new DependencyRequest(collectRequest, filter);
    DependencyResult result = system.resolveDependencies(session, request);

    for (ArtifactResult artifactResult : result.getArtifactResults()) {
        System.out.println(artifactResult.getArtifact().getFile());
    }
}

private static RepositorySystem newRepositorySystem(DefaultServiceLocator locator) {
    locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class, FileTransporterFactory.class);
    locator.addService(TransporterFactory.class, HttpTransporterFactory.class);
    return locator.getService(RepositorySystem.class);
}

private static RepositorySystemSession newSession(RepositorySystem system) {
    DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
    LocalRepository localRepo = new LocalRepository("target/local-repo");
    session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));
    return session;
}