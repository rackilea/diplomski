@Component
private RuntimeInformation runtimeInformation;

public void execute() throws MojoExecutionException, MojoFailureException {
    String mavenVersion = runtimeInformation.getMavenVersion();
    getLog().info(mavenVersion); // prints 3.3.9 when running the build with that version
}