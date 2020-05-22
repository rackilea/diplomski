List<DependencyNode> allNodes = new ArrayList<DependencyNode>();
DependencyManagement dependencyManagement = project.getDependencyManagement();
List<Dependency> dependencies = dependencyManagement.getDependencies();

getLog().info("found the following managed dependencies:");
for (Dependency dependency : dependencies) {
    getLog().info(dependency.toString());
    String groupId = dependency.getGroupId();
    String artifactId = dependency.getArtifactId();
    String version = dependency.getVersion();
    String scope = dependency.getScope();
    String type = dependency.getType();
    Artifact artifact = artifactFactory.createArtifact(groupId, artifactId, version, scope, type);
    MavenProject buildFromRepository = mavenProjectBuilder.buildFromRepository(artifact, remoteRepositories, localRepository);
    allNodes.addAll(getDependencies(buildFromRepository));
}