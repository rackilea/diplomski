public class Main {
    public static void main(String[] args) {
        final int[] finalArray = new int[5];
        finalArray[0] = 10;
        System.out.println(finalArray[0]);
        finalArray[0] = 9001;
        System.out.println(finalArray[0]);
        finalArray = new int[5] //compile error!!!
    }
}