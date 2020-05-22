public class HTest {

    public static Integer i;

    @Before
    public void before(){
        i = 10;
    }

    @Test
    public void print() {
        System.out.println(i);
    }
}