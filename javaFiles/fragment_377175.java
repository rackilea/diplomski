public class Whatever {
    private final static char hold = '*';

    public static String addStars(List<Character> str) {
        if (str.isEmpty()) {
            return "";
        } else if (str.size() < 2) {
            //Don't add star after last character
            return "" + str.get(0);
        }

        //Add only one star per iteration
        str.listIterator(1).add(hold);
        List<Character> sublist = str.subList(2, str.size());
        return "" + str.get(0) + hold + addStars(sublist);
    }

    public static void main(String[] args) {
        ArrayList<Character> example = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        System.out.println(example); // [a, b, c]
        System.out.println(addStars(example)); // a*b*c
        System.out.println(example); // [a, *, b, *, c]
    }
}