public class Scope {
    public static void main(String[] args) {
        System.out.println(getI());
        System.out.println(getI());
    }
    private static int getI() {
        int i = 0;
        i++;
        return i;
    }
}