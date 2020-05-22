class A implements I {

    @Override
    public void hello() {
        System.out.println("Hello from class A");
    }
}

class B implements I {

    @Override
    public void hello() {
        System.out.println("Hello from class B");
    }
}

interface I {
    public void hello();
}

public class Main {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws OperationNotSupportedException
     */
    public static void main(final String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        I i = (I) Class.forName("A").newInstance();
        i.hello();
        i = (I) Class.forName("B").newInstance();
        i.hello();
    }
}