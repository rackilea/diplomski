public static double averageMarks(String aCode)
{
    double sum[] = new double[subject.length];
    double average[] = new double[subject.length];

    for (int j = 0; j < subject.length; j++) {
        for (int i = 0; i < studentNum.length; i++) {
            sum[j] += marks[j][i];

        }
        average[j] = (sum[j] / studentNum.length); // average[0] is the average mark of Mathermatics and average[1] is the average mark of English

        if (aCode.equals(subject[j])) {
            return average[j];
        }
    }
    return 0;
}