public class UseServiceImpl implements UseService,ApplicationContextAware {
     private ApplicationContext context;
     XyzService xyzService= context.getBean(XyzServiceImpl.class);
   // getter and setter for applicationContext
     private XyzService xyzService= null;
   // getters and setters...
    xyzService.doSomething();
}