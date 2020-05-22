public static void main(String[] args) {
    CurrentClass.<RuntimeException>sneakyThrow(new Exception());
}
@SuppressWarnings("unchecked")
private static <E extends Throwable> void sneakyThrow(Throwable t) throws E { 
  throw (E)t; 
}