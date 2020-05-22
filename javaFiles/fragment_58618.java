public class Test2 {
    Test1 t1 = new Test1(10);

    Test2(int i) {
        t1 = new Test1(i);
    } 

    Test2(int i, String s) {
        t1 = new Test1(i);
    } 

    public static void main(String[] args) {
        Test2 t2 = new Test2(5);
    }
}