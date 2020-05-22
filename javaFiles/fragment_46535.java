@Entity
 @Table(name="like")
 public class Like {

   @Id
   @GeneratedValue
   @Column(name="like_id")
   private Integer id;

   @ManyToOne
   @JoinColumn(name="likable_id", nullable=false)
   private Likable likable;

   @ManyToOne
   @JoinColumn(name="user_id", nullable=false)
   private User user;
}