public class C {
    private B b;
    void method2(){
        b = new B();
        b.setname("BBB");
    }
    public void setName(String newName)
    {
         b.setname(newName);
    }
    public String getName()
    {
         return b.getName();
    }
}