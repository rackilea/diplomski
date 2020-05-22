for (int index = 0; index < scores.length; index++) {
  int sum = 0;
  for (int j = 0; j < scores[index].length; j++) {
    sum = sum + scores[index][j];
  }
  int average = sum / scores[index].length;
  System.out.println(nicknames[index] + " bowled rounds of "
      + Arrays.toString(scores[index])
      + " and had an average of " + average);
}