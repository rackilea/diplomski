static void highestStudentAvgMark() {
  double[] averagesArray = findAverages();
  double max = averagesArray[0];
  for (int i = 1; i < averagesArray.length; i++) {
    if (averagesArray[i] > max) {
      max = averagesArray[i];
    }
  }
  findMark(max, averagesArray);
  System.out.println(max);
}