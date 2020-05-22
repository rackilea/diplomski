@Mojo(name = "start", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST)
public class StartMojo extends AbstractMojo {

    @SuppressWarnings("unchecked")
    @Override
    public void execute() throws MojoExecutionException {
        getPluginContext().put("myService", new MyService("foo"));
    }

}