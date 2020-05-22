private Double getDouble(String number) {
 try {
  return Double.parseDouble(number);
 } catch(NumberFormatException e) {
  return null;
 }
}