public class DatabaseQueries {

  private static final Map<DatabaseActions, String> database;
  static { // keep variable declaration and initializer close for readability
    Map<DatabaseActions, String> map = new HashMap<>();// mutable ref during initialization
    map.put(
      DatabaseActions.LIST_CHIHUAHUA,
      "SELECT id, nome, immagine FROM chihuahua ORDER BY data_nascita DESC"
    );
    // more...
    database = Collections.unmodifiableMap(map);// enforce read-only
  }

  public static Map<DatabaseActions, String> getDatabase() {
    return database;// no wrapping necessary, it’s already wrapped
  }
}