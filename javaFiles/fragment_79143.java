public class Game
{
    private static Map<String, int> users = new ConcurrentHashMap<String, int>();

    public void endGame(Sring user) {

        //do something for user
        updateDatabase(user, users.get(user));

    }
    public void roll(String user) {
        //roll implementation
    }

    private void updateDatabase(String user, int numberOfCoins) {

        //update database for user here.
    }
}