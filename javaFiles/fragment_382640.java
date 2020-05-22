public class BeanThatNeedsSignupMailSession {

    @Autowired
    @Qualifier("signupMailSession")
    private Session mailSession;

}