public static List<Map<String, String>> merge(
      List<Map<String, String>> teams, List<Map<String, String>> chances) {

  // create the result
  List<Map<String, String>> result = new ArrayList<Map<String, String>>();

  // now we assume that for each team there is one chance (valid?)
  for (Map<String, String> team:teams) {
    boolean success = false;
    Map<String, String> combined = new HashMap<String, String>();
    combined.putAll(team);

    String id = team.get("TeamID");

    // now we have to find the "chance" map
    for (Map<String, String> chance:chances) {
       if (chance.get("TeamID").equals(id)) {
          combined.putAll(chance);
          boolean success = true;
          break;
       }
    }

    if (!success) {
      // there was no entry in chances map with this id!! -> handle problem
    }
    result.add(combined);
  }
  return result;
}