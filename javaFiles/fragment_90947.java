public class Transformation {
  public static final Transformation NO_OP =
      new Transformation(ImmutableMap.of());

  private final Map<String, String> tasks;

  public Transformation(Map<String, String> tasks) {
    // could add some sanity checks here that tasks.keySet() doesn't
    // contain any unexpected values
    this.tasks = tasks;
  }

  public Entry<String, String> apply(Entry<String, String> e) {
    String key = e.getKey();
    String value = e.getValue();
    for (Entry<String, String> task : tasks.entrySet()) {
      switch (task.getKey()) {
        case "linkedTo":
          // this assumes we've inverted the old/new mapping. If not pass
          // the new key name into the constructor and use that here instead
          key = task.getValue();
          break;
        case "decode":
          if (Boolean.valueOf(task.getValue())) {
            // or whichever decoding function you prefer
            value = URLDecoder.decode(value);
          }
          break;
        // and so on
        default:
          throw new IllegalArgumentException(
              "Unknown task " + task.getKey());
      }
    }
    return Maps.immutableEntry(key, value);
  }