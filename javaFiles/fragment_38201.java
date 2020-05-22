/** Computes the RMS volume of a group of signal sizes */
public double volumeRMS(int start, int length) {
    long sum = 0;
    int end = start + length;
    int len = length;
    if (end > audioData.length) {
        end = audioData.length;
        len = end - start;
    }
    if (len == 0) {
        return 0;
    }
    for (int i=start; i<end; i++) {
        sum += audioData[i];
    }
    double average = (double)sum/len;

    double sumMeanSquare = 0;;
    for (int i=start; i<end; i++) {
        double f = audioData[i] - average;
        sumMeanSquare += f * f;
    }
    double averageMeanSquare = sumMeanSquare/len;
    double rootMeanSquare = Math.sqrt(averageMeanSquare);

    return rootMeanSquare;
}