public static void main(String[] str) {
    User u = new User();
    u.setName("hello");
    Field f = u.getFirstNonNullField();
    try {
      System.out.print(f.get(u));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      // TODO handle this exception as you want
      e.printStackTrace();
    }
  }