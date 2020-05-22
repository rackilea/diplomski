public String[] unitMarks(int[] grades, String[] unitCode) {
    double sum = 0;
    for (double i : grades) {
        sum += i;
    }
    double average = (sum / grades.length);
    String[] result = new String[grades.length +1];
    for (int i = 0; i < grades.length; i++) {
        String combination = unitCode[i] + grades[i];
        result[i] = combination;
    }
    result[result.length-1]= "Average:"+average;
    return result;
}