public class Player extends ArmedHumanoid {

  private static Player instance = new Player();

  private Player() {}

  public static Player getIntstance() {
    return instance
  }

}