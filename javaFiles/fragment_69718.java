public class CountWordsInParagraphCaseInsensitive {


    public static void main(String[] args) {
        StringBuilder paragraph = new StringBuilder();
        paragraph.append("I am at office right now.")
                .append("I love to work at oFFicE.")
                .append("My OFFICE located at center of kathmandu valley");
        String searchWord = "office";
        Pattern pattern = Pattern.compile(searchWord, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(paragraph);
        int count = 0;
        while (matcher.find())
            count++;
        System.out.println(count);

    }

}