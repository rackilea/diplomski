@Component
public class IDInterceptor extends DescriptorEventAdapter {
    private static SomeSpringBean someSpringBean;

    @Autowired(required = true)
    @Qualifier("SomeSpringBean")
    public void setSomeSpringBean(SomeSpringBean bean) {
        someSpringBean = bean;
    }   

    @Override
    public void preInsert(DescriptorEvent event) {

    }
}