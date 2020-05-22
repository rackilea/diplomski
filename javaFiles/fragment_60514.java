@Component
public class MessageSourceExternalizer {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        //Attention LocaleContextHolder.getLocale() is thread based,
        //maybe you need some fallback locale
        return messageSource.getMessage(code, new Object[0], LocaleContextHolder.getLocale());
    } }

@Service
public YourService {

    @Autowired
    private MessageSourceExternalizer messageSourceExternalizer;

    public void yourServiceMethod() {
        ....
        YourNotSpringBean yourNotSpringBean 
             = new YourNotSpringBean(messageSourceExternalizer);
        yourNotSpringBean.doSomething(...);
    } }


public class YourNotSpringBean {

    private final MessageSourceExternalizer messageSourceExternalizer;
    public YourNotSpringBean(MessageSourceExternalizer messageSourceExternalizer) {
         this.messageSourceExternalizer = messageSourceExternalizer;
    }

    public void doSomething() {
        ....
        this.messageSourceExternalizer.getMessage("application.errorcode.sessionExpiry");
    }

}