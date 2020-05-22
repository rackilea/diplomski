public class Squad {

   Map<String, List<Player>> substitutes = new HashMap<>();

   // add the player lists into the map

   /*
   * Returns the list of players for the given team name,
   * can be {@code null} if no player list has been stored
   * with the team name.
   */
   public List<Player> getList(String teamName) {
      return substitutes.get(teamName);
   }
}