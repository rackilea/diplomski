public class A
    {
        private int num = 3;

        private void sub()
        {
          num = 10;            
          add();
        }
        private void add()
        { 
              system.out.println(num);
        }
    }

public class A
{
    private int num = 3;

    private void sub()
    {
        A obj_A = new A();
        num = 10;      
        obj_A.add();
    }
    private void add()
    { 
           system.out.println(num);
    }
}