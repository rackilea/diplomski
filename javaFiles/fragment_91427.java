import java.util.*;
public class SearchAndContext {
    public static void main(String[] args) {
        String text = "The path of the righteous man is beset on all sides by "
        + "the iniquities of the selfish and the tyranny of evil men. Blessed "
        + "is he, who in the name of charity and good will, shepherds the "
        + "weak through the valley of darkness, for he is truly his brother's "
        + "keeper and the finder of lost children. And I will strike down "
        + "upon thee with great vengeance and furious anger those who would "
        + "attempt to poison and destroy my brothers. And you will know my "
        + "name is the Lord when I lay my vengeance upon thee.";

        List<String> words = Arrays.asList(text.split(" "));
        final int W = 3;
        final int N = words.size();
        String[] queries = { "vengeance", "and", "monkeys" };
        for (String query : queries) {
            List<String> search = words;
            System.out.println("Searching for " + query);
            for (int idx = -1, pos; (pos = search.indexOf(query)) != -1; ) {
                idx += (pos+1);
                int left = Math.max(0, idx - W);
                int right = Math.min(N, idx + W + 1);
                System.out.println(words.subList(left, right));
                search = search.subList(pos+1, search.size());
            }
        }
    }
}