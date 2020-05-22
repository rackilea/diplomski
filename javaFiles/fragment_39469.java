public class method {
    int add = 0; 

    public void multipleThree() {
        for (int a=3; a<1000; a+=3) {
            System.out.println(a);
            add += a;
        }
    }

    public void multipleFive(){
        for (int b=5; b<1000; b+=5) {
            System.out.println(b);
            add += b;
        }
    }

    public void sum(){
        System.out.println("The sum is "+ add);
    }

}