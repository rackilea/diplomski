private static String getString() {
  try{
    return "a";
  } finally {
    return "b";
  }
}