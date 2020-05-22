@Controller
public class ExampleController{

   //next declaration will cause ERROR
   @Autowired
   private TdctFixedLengthReport report;

}