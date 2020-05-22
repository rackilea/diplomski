private double calculateAverage(List <Integer> marks) {
  Integer sum = 0;
  if(!marks.isEmpty()) {
    for (Integer mark : marks) {
        sum += mark;
    }
    return sum.doubleValue() / marks.size();
  }
  return sum;
}