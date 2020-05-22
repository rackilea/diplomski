@Component(value = "beanDTO")
public class BeanDTO {
    @Autowire
    private List<InterfaceType> implementingBeans;

    public List<InterfaceType> getImplementingBeans() {
        return implementingBeans;
    }
}