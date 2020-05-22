public class Main {

    public interface Visitor{
        int doJob(int a, int b);
    }


    public static void main(String[] args) {
        Visitor adder = new Visitor(){
            public int doJob(int a, int b) {
                return a + b;
            }
        };

        Visitor multiplier = new Visitor(){
            public int doJob(int a, int b) {
                return a*b;
            }
        };

        System.out.println(adder.doJob(10, 20));
        System.out.println(multiplier.doJob(10, 20));

    }
}