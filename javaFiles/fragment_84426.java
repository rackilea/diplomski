@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private UserService userService;

@PostMapping(value = "/changePassword")
    public ResponseEntity<ResponseData> changePassword(@RequestBody PasswordChange pass) {
        try {
            userService.changePassword(pass);
            ResponseData resData = new ResponseData();
            resData.setResponce(true);
            resData.setData(Collections.singletonList("Password change successfully"));
            return new ResponseEntity<>(resData, HttpStatus.OK);
        } catch (PasswordAndConfirmationAreDifferentException e) {
            ResponseData resData = new ResponseData();
            resData.setResponce(false);
            resData.setData("Password incorrect");
            return new ResponseEntity<>(resData, HttpStatus.BAD_REQUEST);
        }
    }
}