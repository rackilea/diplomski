/**
 * The Maven Project Object
 * 
 * @parameter expression="${project}"
 * @required2.0
 * @readonly
 */
protected MavenProject project;

/**
 * @component
 */
protected ArtifactResolver artifactResolver;

/**
 * @component
 */
protected RemoteRepositoryManager remoteRepositoryManager;

private Object invoke( Object object, String method )
        throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    return object.getClass().getMethod( method ).invoke( object );
}

private org.apache.maven.model.resolution.ModelResolver makeModelResolver() throws MojoExecutionException {
    try {
        ProjectBuildingRequest projectBuildingRequest =
        (ProjectBuildingRequest) invoke( project, "getProjectBuildingRequest" );

        Class c = Class.forName("org.apache.maven.repository.internal.DefaultModelResolver");
        Constructor ct = c.getConstructor(new Class[]{RepositorySystemSession.class, 
                RequestTrace.class, String.class,
                ArtifactResolver.class, RemoteRepositoryManager.class,
                List.class});
        ct.setAccessible(true);
        return (org.apache.maven.model.resolution.ModelResolver) ct.newInstance(new Object[]{
                projectBuildingRequest.getRepositorySession(), 
                null, null, artifactResolver, remoteRepositoryManager, 
                project.getRemoteProjectRepositories()});
    } catch (Exception e) {
        throw new MojoExecutionException("Error instantiating DefaultModelResolver", e);
    }
}