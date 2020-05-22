@Mojo( name = "run", threadSafe = true, requiresDependencyResolution = ResolutionScope.TEST )
public class CustomAntMojo
    extends AntRunMojo
{

    @Component
    private PluginDescriptor pluginDescriptor;

    public void execute()
        throws MojoExecutionException
    {
        File buildDirectory = new File( getMavenProject().getBuild().getOutputDirectory() );

        // add the build directory to the classpath for the classloader
        try {
            ClassRealm realm = pluginDescriptor.getClassRealm();
            realm.addURL(buildDirectory.toURI().toURL());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        // configure the log4j logger to output the ant logs to the maven log
        BasicConfigurator.configure( new MavenLoggerLog4jBridge(getLog()));
        super.execute();

    }
}