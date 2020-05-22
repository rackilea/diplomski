for (int test = 0; test < grades.length; test++) {
  int total  = 0;
  for(int student=0; student<names.length; student++) {
    total += grades[student][test]
  }
  double avgForTest = (double) total/names.length;
 }