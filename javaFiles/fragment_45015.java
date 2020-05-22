public class checkingDivisibility {
    public static void main(String[] args) {
        int list[] = {1, 2, 3, 6, 8, 10, 12, 14, 15, 17, 19, 21};
        for (int x : list) {
            if (x % 2 == 0) {
                System.out.println(x + "div by 2 possible");
            } 
            if (x % 3 == 0) {
                System.out.println(x + "div by 3 possible");
            }  
            if (x % 5 == 0) {
                System.out.println(x + "div by 5 possible");
            }
        }
    }
}