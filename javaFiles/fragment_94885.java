import org.springframework.transaction.annotation.Transactional;
*
@Transactional
public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }