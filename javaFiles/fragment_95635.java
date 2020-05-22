@Component
@Scope(BeanDefinition.SCOPE_SESSION)
public class MySessionBean()

  private String content;

  Getter/setter
}

@Controller
...

   @Autowire
   private MySessionBean mySessionBean;

   ...
   public String processThisValue( @ModelAttribute( "myValues" ) MyBean myBean,
        ModelMap model) {
     //myBean is only a simple class!!!!!
     ...
     this.mySessioBean.setContent(valuePassed);
     ...
   }


@Service
public class Sample() {

  @Autowire
  private MySessionBean mySessionBean;

  public void doSomething() {
     System.out.println("the current users value:" + mySessionBean.getValue());
  }
 }