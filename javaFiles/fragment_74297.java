public class Comparables {

  static class User implements Comparable<User> {
    @Override
    public int compareTo(User user) {
      return 0;
    }
  }

  /**
   * This class cannot be used with Collections.sort because an
   * UncomparableUser is not comparable with itself. However, notice
   * that you get no compiler error just for implementing
   * Comparable<String>.
   */
  static class UncomparableUser implements Comparable<String> {
    @Override
    public int compareTo(String user) {
      return 0;
    }
  }

  public static void main(String[] args) {
    List<User> users = Arrays.asList(new User());

    // Using this would cause a compiler error
    // List<UncomparableUser> users = Arrays.asList(new UncomparableUser());

    Collections.sort(users);
  }
}