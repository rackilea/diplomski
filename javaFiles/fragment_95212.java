@Component
public class MySampleBean {
   @Autowired // better constructor injection, but not relevant for this question
   private UtilClass utilClass;

   public void foo() {
      ... 
      utilClass.doSomething();
      ...
   }
}