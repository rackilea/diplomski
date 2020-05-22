public class Main {
    public static <X extends String&List<Integer>> void main(String[] args) {
        String s = Main.<X>newList();
        System.out.println(s);
    }

    private static <T extends List<Integer>> T newList() {
        return (T) new ArrayList<Integer>();
    }
}