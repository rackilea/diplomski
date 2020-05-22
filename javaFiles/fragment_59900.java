package stackoverflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static class Results {

        private int wins = 0;
        private int looses = 0;

        public void addWin() {
            wins++;
        }

        public void addlost() {
            looses++;
        }

        @Override
        public String toString() {

            return wins + " " + looses;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(
                "FileLocation.txt"));
        String line;

        Map<String, Results> teamResults = new HashMap<>();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");
            Results team1 = teamResults.getOrDefault(data[0], new Results());
            Results team2 = teamResults.getOrDefault(data[2], new Results());
            if (Integer.valueOf(data[1]) > Integer.valueOf(data[3]))
                {team1.addWin();
                team2.addlost();}
            else
                {team1.addlost();
                team2.addWin();}
            teamResults.put(data[0], team1);
            teamResults.put(data[2], team2);

        }

        for (String string : teamResults.keySet()) {
            Results teamres = teamResults.get(string);
            System.out.println(string+ " " +teamres);
        }

    }

}