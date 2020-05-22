@RunWith(Parameterized.class)
public class MyTest{ 
     @Parameters
    public static Collection<Object[]> data() {
           /*create and return a Collection
             of Objects arrays here. 
             Each element in each array is 
             a parameter to your constructor.
            */

    }

    private int a,b,c;


    public MyTest(int a, int b, int c) {
            this.a= a;
            this.b = b;
            this.c = c;
    }

    @Test
    public void test() {
          //do your test with a,b
    }

    @Test
    public void testC(){
        //you can have multiple tests 
        //which all will run

        //...test c
    }
}