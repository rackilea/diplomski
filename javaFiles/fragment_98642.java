public class Services implements DisposableBean {

    ClassPathXmlApplicationContext ctx;
    private MyAService myAService;
    private MyBService myBService;

    public Services() {
       this.ctx = new ClassPathXmlApplicationContext("services-context.xml");

       // these are configured in the services-context.xml
       this.myAService = ctx.getBean("myAService");
       this.myBService = ctx.getBean("myBService");
    }

    // Add getters for your services

    @Override
    public void destroy() throws Exception {
       this.myAService = null;
       this.myBService = null;
       this.ctx.destroy();
       this.ctx = null;
    }
}