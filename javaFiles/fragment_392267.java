public class DatabaseQueries {
  private static Map<DatabaseActions, String> database = new HashMap<>();
  static {
    database.put(
      DatabaseActions.LIST_CHIHUAHUA,
      "SELECT id, nome, immagine FROM chihuahua ORDER BY data_nascita DESC"
    );
  }
}