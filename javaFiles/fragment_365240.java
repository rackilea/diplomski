@SpringUI
public class MainUI extends UI {
    @Autowired
    LoginView loginView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setContent(loginView);
    }
}