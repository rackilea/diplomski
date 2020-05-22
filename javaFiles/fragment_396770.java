@Controller
public class ExampleController{

   @Autowired
   private BeanFactory beanFactory;

   @RequestMapping("/")
   public String exampleMethod(){
      TdctFixedLengthReport report = 
         beanFactory.getBean(TdctFixedLengthReport.class, "sourceSystem");
   }
}