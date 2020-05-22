public class Assignment6 {
    private static int amount = 0;
    public static void main(String[] args) {
        amount = (int)(Double.parseDouble(args[0])*100);
        System.out.println("Five: " + computeCoin(500));
        System.out.println("one: " + computeCoin(100) );
        System.out.println("Q : " + computeCoin(25) );
        System.out.println("D : " + computeCoin(10) );
        System.out.println("N : " + computeCoin(5) );
        System.out.println("P : " + computeCoin(1) );
    }

    public static int computeCoin(int cointValue) {
        int val = amount / cointValue;
        amount -= val * cointValue;
        return val;
    }
}