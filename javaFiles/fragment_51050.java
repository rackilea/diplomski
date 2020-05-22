public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        List<User> ul = userService.getUsersByName(user.getName());
        if(ul.size() > 0){
            String argName = i18n("info.name");
            errors.reject("error.duplicate",new Object[]{argName}, null);
        }
    }

    private String i18n(String messageKey) {
        return messageSource.getMessage(messageKey, null, getLocale();
    } 
}