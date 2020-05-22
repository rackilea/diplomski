package example;

public class A extends B implements I{
    public static void main(String...args)
    {
        new A().foo();
        new B().foo();
        new C().foo();
    }
}
class B extends C{

} 
class C implements I{

    @Override
    public void foo() {
        boolean implementsDirectly = false;
        for (Class c : getClass().getInterfaces()) {
            if(c.getName().equals("example.I")) {
                implementsDirectly = true;
            }
        }
        if(implementsDirectly) {
            System.out.println("The class " + getClass().getName() +" does implement I directly in the class definition");
        } else {
            System.out.println("The class " + getClass().getName() +" does not implement I directly in the class definition");
        }
    }

}

interface I {
    void foo();
}