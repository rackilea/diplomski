public class Test {
    static String radStat (int freq) {
        return String.format ("%d.%d", freq / 1000, (freq / 100) % 10);
    }

    public static void main(String args[]) {
        System.out.println("107900 -> " + radStat (107900));
        System.out.println(" 87900 -> " + radStat ( 87900));
        System.out.println("101700 -> " + radStat (101700));
    }                          
}