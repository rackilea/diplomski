public String normalize(String input) {
  String output = Normalizer.normalize(input, Normalizer.Form.NFD); 
  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

  return pattern.matcher(output).replaceAll("");
}