@RestController
public class MyController{
    private UserService userService;

    public MyController(UserService userService){
        this.userService = userService;
    }

    public void myMethod() {
        User authUser = userService.getLoggedInUser();
    }
}