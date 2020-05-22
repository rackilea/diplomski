import java.util.ArrayList;
import java.util.Collections;

public class SortDancers {

    public static void main(String[] args) {

        System.out.println(new SortDancers().listAllDancesAndPerformers());
    }

    public String listAllDancesAndPerformers() {

        ArrayList<String> dancesData = new ArrayList<String>();
        dancesData.add("Dance1 \t Kelly, Andrew, Nathan");
        dancesData.add("Dance2 \t John, Sally, Kevin, Abby");
        dancesData.add("Dance3 \t Laura, Benny, Jane");
        // I assume you get this kind of data from getCSV()

        int lineNumber = 0;
        String result = "";

        for (String line : dancesData) {

            String[] splitByTab = line.split("\t");

            String[] separatedNames = splitByTab[1].split(",");

            lineNumber++;
            result += lineNumber + ": ";
            result += (splitByTab[0].trim()) + "\n";

            ArrayList<String> separatedNamesList = new ArrayList<String>();
            for (int i = 0; i < separatedNames.length; i++) {
                separatedNamesList.add(separatedNames[i].trim());
            }

            Collections.sort(separatedNamesList);
            result += String.join(", ", separatedNamesList);
            result += "\n";
        }

        return result;
    }
}