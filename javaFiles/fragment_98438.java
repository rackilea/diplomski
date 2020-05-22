@Entity(name = "user_ratings")
public class UserRating {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer id;

    @ManyToOne(nullable = false)
    @JoinColumn(name = "ratingId")
    private Rating rating;

    @ManyToOne(nullable = false)
    @JoinColumn(name = "authorId")
    private User ratedBy;
 }