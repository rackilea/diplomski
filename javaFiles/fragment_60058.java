public class AllLocales {
  // Which Locales get priority.
  private static final Locale[] priorityLocales = {
    Locale.US,
    Locale.UK
  };

  private static class MyLocale implements Comparable<MyLocale> {
    // My Locale.
    private final Locale me;

    public MyLocale(Locale me) {
      this.me = me;
    }

    // Convenience
    public String getCountry() {
      return me.getCountry();
    }

    @Override
    public int compareTo(MyLocale it) {
      // No duplicates in the country field.
      if (getCountry().equals(it.getCountry())) {
        return 0;
      }
      // Check for priority ones.
      for (int i = 0; i < priorityLocales.length; i++) {
        Locale priority = priorityLocales[i];
        // I am a priority one.
        if (getCountry().equals(priority.getCountry())) {
          // I come first.
          return -1;
        }
        // It is a priority one.
        if (it.getCountry().equals(priority.getCountry())) {
          // It comes first.
          return 1;
        }
      }
      // Default to straight comparison.
      return getCountry().compareTo(it.getCountry());
    }
  }

  public static List<String> listAll() {
    Set<MyLocale> byLocale = new TreeSet();
    // Gather them all up.
    for (Locale locale : Locale.getAvailableLocales()) {
      final String isoCountry = locale.getDisplayCountry();
      if (isoCountry.length() > 0) {
        //System.out.println(locale.getCountry() + ":" + isoCountry + ":" + locale.getDisplayName());
        byLocale.add(new MyLocale(locale));
      }
    }
    // Roll them out of the set.
    ArrayList<String> list = new ArrayList<>();
    for (MyLocale l : byLocale) {
      list.add(l.getCountry());
    }
    return list;
  }

  public static void main(String[] args) throws InterruptedException {
    // Some demo usages.
    List<String> locales = listAll();
    System.out.println(locales);
  }
}