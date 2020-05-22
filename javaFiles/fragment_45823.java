public class Updater {
    public static void run() {
        for (Alien alien : AlienManager.getAliens()) {
            Location loc = alien.getLocation();
            int x = loc.getX();
            int y = loc.getY();
            alien.setLocation(new Location(x, y));
        }
    }
}