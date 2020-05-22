public class BookEntityListener {

    @PostPersist
    public void postPersist(User user) {
        // do your logic
    }

}

public class PasswordValidator {

    @PrePersist
    @PreUpdate
    public void validatePassword(User user) {
        if (passwordTooShort(user.password())
            throw new PersistenceException("Password too short");
    }

}