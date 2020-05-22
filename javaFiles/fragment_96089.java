import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseScore {

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("http://www.skore.com/en/soccer/england/premier-league/results/all/").get();
        System.out.println("title: " + doc.title());

        Elements dls = doc.select("dl");

        for (Element link : dls) {
            String id = link.attr("id");

            /* check if then it is a game <dl> */
            if (id != null && id.length() > 3 && "rid".equals(id.substring(0, 3))) {

                System.out.println("Game: " + link.text());

                String idNoRID = id.replace("rid", "");
                // String idNoRID = "1-1229442";
                String scoreURL = "http://www.skore.com/en/scores/soccer/id/" + idNoRID + "?fmt=html";
                Document docScore = Jsoup.connect(scoreURL).get();

                Elements trs = docScore.select("tr");
                for (Element tr : trs) {
                    Elements spanGoal = tr.select("span.goal");
                    /* only enter if there is a goal */
                    if (spanGoal.size() > 0) {
                        Elements score = tr.select("td.score");
                        String playerName = spanGoal.get(0).text();
                        String currentScore = score.get(0).text();
                        System.out.println("\t\tGOAL: " + currentScore + ": " + playerName);
                    }

                    Elements spanGoalPenalty = tr.select("span.goalpenalty");
                    /* only enter if there is a goal */
                    if (spanGoalPenalty.size() > 0) {
                        Elements score = tr.select("td.score");
                        String playerName = spanGoalPenalty.get(0).text();
                        String currentScore = score.get(0).text();
                        System.out.println("\t\tGOAL: " + currentScore + ": " + playerName + " (penalty)");
                    }

                    Elements spanGoalOwn = tr.select("span.goalown");
                    /* only enter if there is a goal */
                    if (spanGoalOwn.size() > 0) {
                        Elements score = tr.select("td.score");
                        String playerName = spanGoalOwn.get(0).text();
                        String currentScore = score.get(0).text();
                        System.out.println("\t\tGOAL: " + currentScore + ": " + playerName + " (own goal)");
                    }
                }
            }
        }
    }
}