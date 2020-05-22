@Service
public class CreateMailboxService {   
    @Autowired UserInfoService mUserInfoService; // this should be mocked
    @Autowired LogicService mLogicService;  // this should be autowired by Spring

    public void createMailbox() {
        // do mething
        System.out.println("test 2: " + mUserInfoService.getData());
    }

    void setUserInfoService(UserInfoService mUserInfoService) {
        this.mUserInfoService = mUserInfoService;
    }
}