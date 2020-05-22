@Service
public class Attribute2Service {

    @Resource
    private BeanSession beanSession;

    @Resource
    private Processor processor;

    @Resource
    private Attribute1 attribute1;

    public void defineAttribute2() {
        Configuration configuration = beanSession.getRootState();
        String value = processor.getValue(configuration, attribute1.getValue()); // Will call Attribute1 service to require the fresh bean
        configuration.getAttribute2().setValue(value);
    }

    public void defineAttribute3() {
        Configuration configuration = beanSession.getRootState();
        String value = processor.getValue(configuration, attribute1.getValue()); // Will call Attribute1 service to require the fresh bean
        configuration.getAttribute3().setValue(value);
    }

}