public final class Secured {

  private static final Set<Class<?>> allowedCallers = new HashSet<>();

  static {
    allowedCallers.add(Allowed.class);
  }

  private static final class SecurityManagerExtension extends SecurityManager {

    private static final int OFFSET = 4;

    @Override
    protected Class<?>[] getClassContext() {
      return super.getClassContext();
    }

    private Class<?> getCaller() {
      try {
        return getClassContext()[OFFSET];
      } catch (ArrayIndexOutOfBoundsException e) {
        return null;
      }
    }
  }

  private Secured() {
    // protect against reflection attack
    Class<?> caller = new SecurityManagerExtension().getCaller();
    if (!this.getClass().equals(caller)) {
      throw new IllegalStateException();
    }
    System.out.println("Secured instance constructed!");
  }

  public static Secured createInstance() {
    // this gets the class name of the calling class
    Class<?> caller = new SecurityManagerExtension().getCaller();
    if (allowedCallers.contains(caller)) {
      System.out.println("Created instance by '" + caller + "'!");
      return new Secured();
    } else {
      System.out.println("No instance created because call was made by '" + caller + "'!");
      return null;
    }
  }
}