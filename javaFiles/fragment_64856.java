public class Main {

    public static <T> void quickSort(T... args) {
    }

    public static void main(String[] args) {
        quickSort(5, "nine", 7, 3, "two", 5, 4, 1);                // warning
        Main.<Integer>quickSort(5, "nine", 7, 3, "two", 5, 4, 1);  // error
    }
}