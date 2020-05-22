import net.sf.cglib.proxy.Enhancer;

public class CGLibProxyMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ClassA.class);
        enhancer.setCallback(new CGLibProxy());
        ClassA a = (ClassA) enhancer.create(new Class[] {ClassB.class}, new Object[] {new ClassB()});
        System.out.println(a.printB());;
        System.out.println(a.otherMethod());
    }
}