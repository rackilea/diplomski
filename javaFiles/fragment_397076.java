@Mojo(name="goal-name", defaultPhase=LifecyclePhase.PACKAGE)
public class MyMojo
    extends AbstractMojo
{
    @Component
    private MavenProject project;

    @Component
    private MavenProjectHelper projectHelper;

    @Component(role=Archiver.class, hint="jar")
    private JarArchiver archiver;


    public void execute() throws MojoExecutionException {
        // Do work...

        // Create JAR file...
        File jarFile=createJarFile(archiver);

        projectHelper.attachArtifact(project, "beans-jar", jarFile);
    }
}