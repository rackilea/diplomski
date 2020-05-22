import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyMatch {

    public void playMatch(int teamA, int teamB, List<String> groups) {
        Random rand = new Random();
        int score1 = rand.nextInt(5) + 0;
        int score2 = rand.nextInt(5) + 0;
        System.out.println("Qtr 1: " + score1 + "   " + score2);

        if (score1 > score2){
            System.out.println(groups.get(teamA) + " win " + score1 + " to " +   
            score2 + " " + groups.get(teamB) + " eliminated.");
            groups.remove(teamB);
        } else if (score2 > score1){
            System.out.println(groups.get(teamB) + " win " + score2 + " to " +  
            score1 + " " + groups.get(teamA) + " eliminated.");
            groups.remove(teamA);
        } else if (score1 == score2) {
            System.out.println(groups.get(teamA) + " tie " + score1 + " to " +
            groups.get(teamB) + " " + score2 + " no team was eliminated.");
        }
    }

    public static void main(String[] args) {
        MyMatch game1 = new MyMatch();
        List<String> groups = new ArrayList<String>(Arrays.asList("team1","team2", "team3"));
        System.out.println("Round 1");
        System.out.println("BEFORE: " + groups);
        game1.playMatch(0, 1, groups);
        System.out.println("AFTER: " + groups);
    }
}