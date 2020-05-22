class User extends AbstractUser<Type, Account> {

    public User() {
        super(Account::new);
    }
}