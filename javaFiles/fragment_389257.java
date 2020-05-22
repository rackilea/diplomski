public class Global extends GlobalSettings {
    private ApplicationContext ctx;

    @Override
    public void onStart(Application app) {
        ctx = new AnnotationConfigApplicationContext(Neo4jConfig.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

    @Override
    public void onStop(Application app){
        ((AnnotationConfigApplicationContext)ctx).close();
    }