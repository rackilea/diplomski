public class Scope {
    public static void main(String[] args) {
        System.out.println(getI());
        System.out.println(getI());
        System.out.println(getI());
        System.out.println(getI());
    }
    private static int i = 0;
    private static int getI() {
        i++;
        return i;
    }
}