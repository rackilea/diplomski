public class Ramddd {
    public static void main(String args[]) {
        String[] words = getWords();
        if (words == null) {
            words = new String[0];
        }
        List<String> other = new ArrayList<String>(Arrays.asList(words));
        other.add("ddd");
    }
}