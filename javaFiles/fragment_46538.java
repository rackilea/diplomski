@Entity
@Table(name="videoGame")
@PrimaryKeyJoinColumn(name="id")
public class Game extends Likable {

   private String title;
   private int nbPlayer;
}