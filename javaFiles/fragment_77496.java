@Projection(name = "summary", types = User.class)
public interface UserSummaryProjection {

    Integer getId();

    String getEmail();

}