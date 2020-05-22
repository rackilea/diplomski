public class LoginController implements ApplicationContextAware {

  private ApplicationContext applicationContext;
  private UserJDBCTemplate userJDBCTemplate;

  public String checkUser(){

     //get your UserJDBCTemplate bean from container and use it
     userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
  }

  //Here, spring will set ApplicationContext
  void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
}