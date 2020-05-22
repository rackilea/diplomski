@Component
@RefreshScope
public class SMSHistoryProperties {

    @Autowired
    Environment env;

    public String getSchema(){     
        return env.getProperty("sms.schema");
    }

    public String getOtherValue(){     
        return env.getProperty("sms.otherValue");
    }
}