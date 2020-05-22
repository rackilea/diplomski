public class BeanThatNeedsContactMailSession {

    @Autowired
    @Qualifier("contactMailSession")
    private Session mailSession;

}