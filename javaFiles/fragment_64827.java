Iterator<String> colorIt = colors.iterator();
Iterator<Integer> brightnessIt = brightness.iterator();
while (brightnessIt.hasNext() && colorIt.hasNext()) {
  String ledColor = colorIt.next();
  int brightnessValue = brightnessIt.next();
}