public class SubwordPrinter2
{
    private static int index;
    private static void generateSubwords(String prefix, String subword, String[] arr) {
        String s;
        for(int i = 0; i < subword.length(); i++) {
            s = prefix + subword.charAt(i);
            arr[index] = s;
            index++;
            generateSubwords(prefix + subword.charAt(i),
                                subword.substring(i + 1, subword.length()),
                                arr);
        }
    }

    public static void generateAllSubwords(String word) {
        index = 0;
        String[] subwords = new String[(int)Math.pow(2, word.length()) - 1];
        generateSubwords("", word, subwords);
        for(String s : subwords) {
            System.out.println(s);
        }
    }
}