1:  @Startup
   2:  @Singleton
   3:  public class FooBean {
   4:   
   5:    @PostConstruct 
   6:    void atStartup() { ... }
   7:   
   8:    @PreDestroy
   9:    void atShutdown() { ... }
  10:   
  11:  }