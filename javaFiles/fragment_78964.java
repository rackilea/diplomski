private String onButtonClicked() {
return names[getRandomNumber(0, names.length - 1);];

}

private static int getRandomNumber(int begin, int end) {
  Random generator = new Random();
  return generator.nextInt(end - begin + 1) + begin;
}