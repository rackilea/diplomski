public class UserPropertyEditor extends PropertyEditorSupport {

    private UserService userService;

    public UserPropertyEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getAsText() {
        //Handle null value, value of incorrect type, etc here

        return String.valueOf(((User) getValue()).getId());
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        //handle empty string, number format exception, etc

        User user = userService.getUser(integerId);

        setValue(user);
    }

}