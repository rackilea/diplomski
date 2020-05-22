public class Person2 implements IPerson{
    private String name;
    public Person2(String name) {
       this.name = name;
    }
    @Override
    public void say() {
       System.out.println("Person:" + name);
    }
}