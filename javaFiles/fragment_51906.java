@Component
public class SQLConstants {

   @Autowired
   private SMSHistoryProperties prop;

   //~ Static fields/initializers ------------------------------------------

   private String SMS_SCHEMA; 

   @PostConstruct
   public void init(){
        SMS_SCHEMA = prop.getProperty("sms.schema"); 
   }
}