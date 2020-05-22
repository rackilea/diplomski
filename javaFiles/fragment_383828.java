public class Main {

    public static void main(String[] args) {
        int[] elements = { 4, 7, 3, 6, 2, 5, 1 };
        printKth(elements, 3, 0, 6);
        printKth(elements, 3, 1, 5);
        printKth(elements, 2, 2, 6);
    }

    static void printKth(int[] element, int k, int i, int j) {
        if ((i + k - 1) < element.length)
            System.out.println(element[i + k - 1]);
    }
}