class Test {

    public class Arguments {
        public boolean isTest() {
            return true;
        }
    }

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(Arguments.class);
        System.out.println("Getter: " + info.getPropertyDescriptors()[1].getReadMethod());
        System.out.println("Name of property: " + info.getPropertyDescriptors()[1].getName());
    }

}