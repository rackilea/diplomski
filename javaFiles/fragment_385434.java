public class MyClassFactory {

    private MyClassFactory instance = new MyClassFactory();

    private MyClassFactory() {}

    public MyClassFactory getInstance() { return instance; }

    public MyClass create(Class clazz) throws Exception {
       return clazz.newInstance();
    }
}