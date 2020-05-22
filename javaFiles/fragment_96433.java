package fileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class FileParser {

    private static class FuncTime {

        private int seconds;
        private int minutes;


        public FuncTime() {
            this.seconds = 0;
            this.minutes = 0;

        }

        public FuncTime(int seconds, int minutes) {
            this.seconds = seconds;
            this.minutes = minutes;
        }

        public void accumulate(FuncTime ft) {
            this.seconds += ft.seconds;
            while (this.seconds >= 60) {
                this.seconds -= 60;
                this.minutes += 1;
            }
            this.minutes += ft.minutes;
        }

        @Override
        public String toString() {
            return this.minutes + ":" + this.seconds;
        }
    }


    private static void parseInfo(String fileName) {
        // Create structure to store parsed data
        Map<String, FuncTime> data = new HashMap<>();

        // Parse data from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip header (DATA FILE MUST ALWAYS CONTAIN HEADER)
            String line = reader.readLine();
            // Begin to process from 2nd line
            line = reader.readLine();
            while (line != null) {
                // Split funcName and time
                String[] lineInfo = line.split("\\s+");
                String funcName = lineInfo[0].trim();
                // Split time in minutes and seconds
                String[] timeInfo = lineInfo[1].split(":");
                int seconds = Integer.valueOf(timeInfo[1].trim());
                int minutes = Integer.valueOf(timeInfo[0].trim());

                // Store the function name and its times
                FuncTime ft = new FuncTime(seconds, minutes);
                data.put(funcName, ft);

                // Read next line
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Print parsed information
        FuncTime totalTime = new FuncTime();
        for (Entry<String, FuncTime> entry : data.entrySet()) {
            String funcName = entry.getKey();
            FuncTime ft = entry.getValue();
            System.out.println(funcName + " " + ft);
            totalTime.accumulate(ft);
        }
        // Print total
        System.out.println(data.size() + " functions in total time of " + totalTime);
    }

    public static void main(String[] args) {
        String fileName = args[0];

        parseInfo(fileName);
    }

}