@Entity
public class Game {

  ...

  @OneToMany(mappedBy="game")
  private Set<GamePlatform> gamePlatforms;

  ...
}