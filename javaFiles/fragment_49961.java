@IdClass(QueueItemPK.class)
@Entity
@Table(name="queue")
public class QueueItem
{
       @Id
       @ManyToOne(optional=false)
       @PrimaryKeyJoinColumn(name="movieID")
       private Movie movie;

       @Id
       @ManyToOne(optional=false)
       @PrimaryKeyJoinColumn(name="userID")
       private User user;

       @Basic
       private String listOrder;

       ...Getters/Setters...
}

public class QueueItemPK implements Serializable
{
       private static final long serialVersionUID = 1L;

       @Id
       @Column(name="movieID")
       private Integer movie;
       @Id
       @Column(name="userID")
       private Integer user;

       ...Getters/Setter...

       public int hashCode()
       {
           return (movie.getMovieID() + "|" + user.getUserID()).hashCode();
       }

       public boolean equals(Object obj)
       {
           if (obj == this) return true;
           if (obj == null) return false;
           if (!(obj instanceof QueueItemPK)) return false;
           QueueItemPK pk = (QueueItemPK) obj;
           return pk.movie == movie 
               && pk.user == user;
       }
}