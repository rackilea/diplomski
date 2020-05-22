interface UserRepository {
    String authenticate(String username, String password);
}

interface UserRepositoryComponent {
    UserRepository getUserRepository();
}

interface UserServiceComponent extends UserRepositoryComponent {
    default UserService getUserService() {
        return new UserService(getUserRepository());
    }
}

class UserService {
    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    String authenticate(String username, String password) {
        return repository.authenticate(username, password);
    }
}

interface LocalUserRepositoryComponent extends UserRepositoryComponent {
    default UserRepository getUserRepository() {
        return new UserRepository() {
            public String authenticate(String username, String password) {
                return "LocalAuthed";
            }
        };
    }
}

interface MongoUserRepositoryComponent extends UserRepositoryComponent {
    default UserRepository getUserRepository() {
        return new UserRepository() {
            public String authenticate(String username, String password) {
                return "MongoAuthed";
            }
        };
    }
}

class LocalApp implements UserServiceComponent, LocalUserRepositoryComponent {}
class MongoApp implements UserServiceComponent, MongoUserRepositoryComponent {}