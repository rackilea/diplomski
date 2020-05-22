@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

    UserRegistration findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}