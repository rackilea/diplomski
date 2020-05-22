public class SOTest {
    public static void main(String[] args) {
        int[] haystack = { 4, 5, 6, 7, 12, 13, 15, 16, 22, 66, 99, 643 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number in the array: ");
        int needle = sc.nextInt();
        int index = returnIndex(haystack, needle);
        if(index!=-1) // print index only if element is in array.
        System.out.println("Element found at index : " + index);

    }

    public static int returnIndex(int[] haystack, int needle) {
        for (int n = 0; n < haystack.length; n++) {
            if (haystack[n] == needle)
                return n;
        }
        System.out.println("Element not found in array");
        return -1;

    }
}