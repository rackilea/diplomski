@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseData changePassword(PasswordChange pass) {
        User user = userRepository.getOne(pass.getUserId());
        if (null != user) {
            if (pass.getOldPassword().equals(user.getUser_password())) {
                if ((pass.getNewPassword().trim()).equals(pass.getConfirmPassword().trim())) {
                    user.setUser_password(pass.getNewPassword());
                    userRepository.save(user);
                    ResponseData resData = new ResponseData();
                    resData.setResponce(true);
                    resData.setData(Collections.singletonList("Password change successfully"));
                    return resData;
                } else {
                    ResponseData resData = new ResponseData();
                    resData.setResponce(false);
                    resData.setData("Please write the same new password in the confirm section");
                    return resData;
                }
            } else {
                ...
            }
        } else {
            ...
        }
    }
}