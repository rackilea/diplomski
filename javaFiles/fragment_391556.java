public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("RCP", "RYL", "1", "2", "3", "4", "5", "6");
        Collections.sort(list, new Comparator<String>() {
            private boolean isThereAnyNumber(String a, String b) {
                return isNumber(a) || isNumber(b);
            }

            private boolean isNumber(String s) {
                return s.matches("[-+]?\\d*\\.?\\d+");
            }

            @Override
            public int compare(String a, String b) {
                return isThereAnyNumber(a, b)
                        ? isNumber(a) ? 1 : -1
                        : a.compareTo(b);
            }
        });
        System.out.println(list);
    }
}