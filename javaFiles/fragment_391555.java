public class Main {

    private static int customCompare(String a, String b) {
        return isThereAnyNumber(a, b)
                ? isNumber(a) ? 1 : -1
                : a.compareTo(b);
    }

    private static boolean isThereAnyNumber(String a, String b) {
        return isNumber(a) || isNumber(b);
    }

    private static boolean isNumber(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("RCP", "RYL", "1", "2", "3", "4", "5", "6");
        Collections.sort(list, Main::customCompare);
        System.out.println(list);
    }
}