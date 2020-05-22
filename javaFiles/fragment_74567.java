public class Inner {
    private int num2 = 250;

    public void method() {
        System.out.println(num2);//calls inner class num
        System.out.println(num);//should print class T num
        System.out.println(T.this.num2);//should print class T num2
    }   
}