@Entity
@Table(name = "`userrating`")
public class UserRating extends Model {
    public double rating;    

    @OneToOne()
    @JoinColumn(name="id_user")
    public User user;
}