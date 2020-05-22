@Component
class MyBeanImpl implements MyBean, SomeOtherBean1, SomeOtherBean2 {

    @Autowired  
    private MyService myService;

    public MyBeanImpl() {}
}