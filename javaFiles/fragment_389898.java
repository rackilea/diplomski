public class Main {
    public static void main(String args[]) {
        String example[] = { "item 1", "item 2", "item 3",
                "item 4", "item 5", "item 6", "item 7",
                "item 8", "item 9", "item 10" };
        for (int i = 0; i < example.length; i += 2) {
            System.out.println(example[i]);
        }
    }
}