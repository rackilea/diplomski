int age = 0;
try {
  age = Integer.parseInt(ageStr);
} catch (NumberFormatException e) {
  throw new RuntimeException(e);
}