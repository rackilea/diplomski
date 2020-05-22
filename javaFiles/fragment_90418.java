public interface UserDetailsProjection extends JPAProjection{
    @Value("#{target.username}")
    String getUsername();

    @Value("#{target.firstname}")
    String getFirstname();

    @Value("#{target.lastname}")
    String getLastname();
}