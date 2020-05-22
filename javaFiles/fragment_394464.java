public class Class2 {
    private static Class0 c0; 
    private Class3 c3;
    static 
    {
         Class2.c0 = new Class0() {
            Class1 c1 = new Class1();

            @Override
            public void abmethod1(){
                System.out.println("Abstract method 1 called. Size is " + c1.getSize());
            }

            @Override
            public void abmethod2(){
                c1.add(1);
                c1.add(2);
                c1.add(3);
                System.out.println("Abstract method 2 called. Size is " + c1.getSize());
            }
        };
    }
    public Class2(){
       this.c3 = new Class3();
       c3.methodc2(c0);
    }
}