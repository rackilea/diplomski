@Module
public class UserModule {
    @Singleton
    @Provides
    User provideUser() {
        return new User("Hakuna","Matata");
    }

    @Provides
    UserFull provideUserFull(User user) {
        return user;
    }
}