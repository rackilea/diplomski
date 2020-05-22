public static String getSmallestSalaryString(String[] names, int[] ages, double[] salaries) {
    int lowestSalaryIdx= getLowestSalaryIndex(salaries);

    return String.format("Smallest salary:$%,.2f, Name:%s, age:%d" , salaries[lowestSalaryIdx], names[lowestSalaryIdx], ages[lowestSalaryIdx]);
}

public static int getLowestSalaryIndex(double[] salaries) {
    int lowestSalaryIndex = 0;
    double lowestSalary = Double.MAX_VALUE;
    for(int i=0; i<salaries.length; ++i) {
      if (salaries[i] < lowestSalary) {
        lowestSalaryIndex = i;
        lowestSalary = salaries[i];
      }
    }

    return lowestSalaryIndex;
}