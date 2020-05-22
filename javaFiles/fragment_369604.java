import java.util.*;
import java.lang.Math;

public class Statistics {

    private double min;
    private double max;
    private double mean;
    private double median;
    private double deviation;
    private double mode;

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;

    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }

    public static double calcMean(double[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum / n.length;
    }

    public static double calcMedian(double[] n) {
        int middle = n.length / 2;
        if (n.length % 2 == 1) {
            return n[middle];
        } else {
            return (n[middle] + n[middle]) / 2;
        }
    }

    public static double calcDeviation(double[] n) {
        int mean = (int) calcMean(n);
        int squareSum = 0;

        for (int i = 0; i < n.length; i++) {
            squareSum += Math.pow(n[i] - mean, 2);
        }
        return Math.sqrt((squareSum) / (n.length - 1));

    }

    public static double calcMode(double n[]) {
        double value = 0;
        int max = 0;

        for (int i = 0; i < n.length; ++i) {
            int count = 0;
            for (int j = 0; j < n.length; ++j) {
                if (n[j] == n[i]) {
                    ++count;
                }
            }
            if (count > max) {
                max = count;
                value = n[i];

            }
        }

        return value;
    }
}