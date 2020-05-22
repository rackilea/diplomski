@Component 
@ConfigurationProperties(prefix = "myConfig") 
public class MyConfig implements Validator
{

private String foo;
private int myValue;
private String requiredString;
private int smallPositiveInt;

private final Logger log = LoggerFactory.getLogger(this.getClass());

// This means that this validator only supports validating configs of type "MyConfig".
@Override public boolean supports(Class<?> type) { return type == MyConfig.class; }

@Override public void validate(Object o, Errors errors)
{
    MyConfig c = (MyConfig)o;
    log.info("Validating: " + c.toString());
    if(c.getSmallPositiveInt() == 60)
    {
        errors.rejectValue("smallPositiveInt", "error", "Cannot be 60!");
    }
}
}