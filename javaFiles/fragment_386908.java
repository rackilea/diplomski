@Mojo(name = "stop", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class StopMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException {
        MyService service = (MyService) getPluginContext().get("myService");
        getLog().info(service.getValue());
    }

}