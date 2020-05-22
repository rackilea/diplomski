public abstract class ListenerBase{

    protected void wireMe(){
        ApplicationContext ctx = ContextHelper.getCurrentApplicationContext();
        ctx.getAutowireCapableBeanFactory().autowireBean(this);
    }

}