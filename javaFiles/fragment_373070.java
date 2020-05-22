public class GuiceDemo
{
    public static void main(String[] args)
    {
        new GuiceDemo().run();
    }

    public void run()
    {
        Injector injector = Guice.createInjector(new EmptyModule());
        DemoInstance demoInstance = injector.getInstance(DemoInstance.class);
        assert(demoInstance.demoUnbound == null);
    }

    public static class EmptyModule extends AbstractModule
    {
        @Override
        protected void configure()
        {
        }
    }

    public static class DemoInstance
    {
        public final DemoUnbound demoUnbound;

        @Inject
        public DemoInstance(DemoUnbound demoUnbound)
        {
            this.demoUnbound = demoUnbound;
        }
    }

    public interface DemoUnbound
    {
    }
}