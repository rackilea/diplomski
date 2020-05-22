public class Program {

    private static <Programmmm> void foo(Programmmm x){
        System.out.println(x+"-->1");
    }

    private static void foo(final int i){
        System.out.println(i+"-->2");
    }

    public static void main(String[] args) {
        Integer i = 10;
        foo(i);
    }

}