import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseBallStats {

    private String fileName;
    private String teamName;
    private double[] battingAverage = new double[20];

    public BaseBallStats(String fileName) {
        this.fileName = fileName;
        boolean firstLine = true;
        Scanner input = null;
        try {
            File file = new File(fileName);     // you need to create a File object
            input = new Scanner(file); // then pass that File to the scanner
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (firstLine) {
                setTeamName(line);
                firstLine = false;
            }
            int i = 0;
            while (input.hasNext()) {
                battingAverage[i] = input.nextDouble();
                i++;
            }
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String newTeamName) {
        teamName = newTeamName;
    }

    public double findMaxAverage() {
        double max = battingAverage[0];
        for (int i = 1; i < battingAverage.length; i++) {
            if (battingAverage[i] > max) {
                max = battingAverage[i];
            }
        }
        return max;
    }

    public double findMinAverage() {
        double min = battingAverage[0];
        for (int i = 1; i < battingAverage.length; i++) {
            if (battingAverage[i] < min) {
                min = battingAverage[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        BaseBallStats stats = new BaseBallStats("file.txt");
        System.out.println(stats.findMaxAverage());
        System.out.println(stats.findMinAverage());
    }

}