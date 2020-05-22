@Entity
 @Table(name="movie")
 @PrimaryKeyJoinColumn(name="id")  
 public class Movie extends Likable {

     private String title;
    private int duration;
}