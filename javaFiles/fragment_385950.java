public class MyBeanFactory implements BeanFactory {
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        DestinationObject result = new DestinationObject();
        result.setCountries(new LinkedHashSet<Country>());
        return result;
    }
}