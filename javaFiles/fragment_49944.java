@Service
public class UserService {
    //some code
    @PostConstruct
    public void init() {
        if(userListIsEmpty())
            createAdmin();
    }
    //some more code
}