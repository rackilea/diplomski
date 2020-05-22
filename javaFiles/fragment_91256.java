import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Etst extends Application {

    @Override

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        // Labels & inputs Settings
        Label number1 = new Label("Data 1 :");
        Label number2 = new Label("Data 2 :");
        Label number3 = new Label("Data 3 :");
        Label number4 = new Label("Data 4 :");
        Label number5 = new Label("Data 5 :");
        Label resultat1 = new Label("The Result");
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        TextField txt4 = new TextField();
        TextField txt5 = new TextField();
        grid.add(number1, 0, 0);
        grid.add(number2, 0, 1);
        grid.add(number3, 0, 2);
        grid.add(number4, 0, 3);
        grid.add(number5, 0, 4);
        grid.add(resultat1, 0, 6);
        grid.add(txt1, 1, 0);
        grid.add(txt2, 1, 1);
        grid.add(txt3, 1, 2);
        grid.add(txt4, 1, 3);
        grid.add(txt5, 1, 4);
        Button butt = new Button();
        butt.setText("Applique KPPV");
        grid.add(butt, 0, 5);
        // My Main Method
        ///////////////////////////////////


        // ADDED THESE 5 LINES. NOW IT SHOWS A WINDOW WITH THESE VALUES FILLED IN
        txt1.setText("0.0");
        txt2.setText("0.0");
        txt3.setText("0.0");
        txt4.setText("0.0");
        txt5.setText("0.0");

        double insertedInt = Double.parseDouble(txt1.getText());
        double insertedInt2 = Double.parseDouble(txt2.getText());
        double insertedInt3 = Double.parseDouble(txt3.getText());
        double insertedInt4 = Double.parseDouble(txt4.getText());
        double insertedInt5 = Double.parseDouble(txt5.getText());
        double[] query = { insertedInt, insertedInt2, insertedInt3, insertedInt4, insertedInt5 };

        int k = 10;// K : Welaya List Counts
        List<City> cityList = new ArrayList<City>();
        List<Result> resultList = new ArrayList<Result>();
        cityList.add(new City(instances[0], "IRIS0"));
        cityList.add(new City(instances[1], "IRIS1"));
        cityList.add(new City(instances[2], "IRIS2"));
        cityList.add(new City(instances[3], "IRIS3"));
        cityList.add(new City(instances[4], "IRIS4"));
        cityList.add(new City(instances[5], "IRIS5"));
        cityList.add(new City(instances[6], "IRIS6"));
        cityList.add(new City(instances[7], "IRIS7"));
        cityList.add(new City(instances[8], "IRIS8"));
        cityList.add(new City(instances[9], "IRIS9"));
        // find distances
        for (City city : cityList) {
            double dist = 0.0;
            for (int j = 0; j < city.cityAttributes.length; j++) {
                dist += Math.pow(city.cityAttributes[j] - query[j], 2);
            }
            double distance = Math.sqrt(dist);
            resultList.add(new Result(distance, city.cityName));

        }

        Collections.sort(resultList, new DistanceComparator());
        String[] ss = new String[k];
        for (int x = 0; x < k; x++) {
            ss[x] = resultList.get(x).cityName;
        }
        String majClass = findMajorityClass(ss);
        // System.out.println("The Nearest IRIS Class is : "+majClass);

        ///////////////////////////////////
        Scene scene = new Scene(grid, 300, 250);

        // Final Action
        butt.setOnAction(event -> {
            resultat1.setText(majClass);
        });
        primaryStage.setTitle("KNN With JDK");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    // My Method
    // our Data Base
    static double[][] instances = { { 6.300000, 2.500000, 5.000000, 1.900000, 3.000000 },
            { 6.900000, 3.200000, 5.700000, 2.300000, 3.000000 }, { 5.100000, 3.800000, 1.900000, 0.400000, 1.000000 },
            { 6.600000, 2.900000, 4.600000, 1.300000, 2.000000 }, { 5.700000, 4.400000, 1.500000, 0.400000, 1.000000 },
            { 4.600000, 3.400000, 1.400000, 0.300000, 1.000000 }, { 4.300000, 3.000000, 1.100000, 0.100000, 1.000000 },
            { 6.900000, 3.100000, 5.100000, 2.300000, 3.000000 }, { 5.100000, 3.700000, 1.500000, 0.400000, 1.000000 },
            { 6.100000, 2.800000, 4.700000, 1.200000, 2.000000 },

    };

    private static String findMajorityClass(String[] array) {
        // add the String array to a HashSet to get unique String values
        Set<String> h = new HashSet<String>(Arrays.asList(array));
        // convert the HashSet back to array
        String[] uniqueValues = h.toArray(new String[0]);
        // counts for unique strings
        int[] counts = new int[uniqueValues.length];
        // loop thru unique strings and count how many times they appear in
        // origianl array
        for (int i = 0; i < uniqueValues.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals(uniqueValues[i])) {
                    counts[i]++;
                }
            }
        }

        for (int i = 0; i < uniqueValues.length; i++)
            System.out.println(uniqueValues[i]);
        for (int i = 0; i < counts.length; i++)
            System.out.println(counts[i]);

        int max = counts[0];
        for (int counter = 1; counter < counts.length; counter++) {
            if (counts[counter] > max) {
                max = counts[counter];
            }
        }
        System.out.println("max # of occurences: " + max);
        int freq = 0;
        for (int counter = 0; counter < counts.length; counter++) {
            if (counts[counter] == max) {
                freq++;
            }
        }
        int index = -1;
        if (freq == 1) {
            for (int counter = 0; counter < counts.length; counter++) {
                if (counts[counter] == max) {
                    index = counter;
                    break;
                }
            }
            // System.out.println("one majority class, index is: "+index);
            return uniqueValues[index];
        } else {// we have multiple modes
            int[] ix = new int[freq];// array of indices of modes
            System.out.println("multiple majority classes: " + freq + " classes");
            int ixi = 0;
            for (int counter = 0; counter < counts.length; counter++) {
                if (counts[counter] == max) {
                    ix[ixi] = counter;// save index of each max count value
                    ixi++; // increase index of ix array
                }
            }

            for (int counter = 0; counter < ix.length; counter++)
                System.out.println("class index: " + ix[counter]);

            // now choose one at random
            Random generator = new Random();
            // get random number 0 <= rIndex < size of ix
            int rIndex = generator.nextInt(ix.length);
            System.out.println("random index: " + rIndex);
            int nIndex = ix[rIndex];
            // return unique value at that index
            return uniqueValues[nIndex];
        }

    }

    private static double meanOfArray(double[] m) {
        double sum = 0.0;
        for (int j = 0; j < m.length; j++) {
            sum += m[j];
        }
        return sum / m.length;
    }

    // simple class to model instances (features + class)
    static class City {
        double[] cityAttributes;
        String cityName;

        public City(double[] cityAttributes, String cityName) {
            this.cityName = cityName;
            this.cityAttributes = cityAttributes;
        }
    }

    // simple class to model results (distance + class)
    static class Result {
        double distance;
        String cityName;

        public Result(double distance, String cityName) {
            this.cityName = cityName;
            this.distance = distance;
        }
    }

    // simple comparator class used to compare results via distances
    static class DistanceComparator implements Comparator<Result> {
        @Override
        public int compare(Result a, Result b) {
            return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
        }
    }

}