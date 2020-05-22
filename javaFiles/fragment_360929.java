public class SignUpPresenter {

    private View view;
    private EmailValidator validator;

    public SignUpPresenter(View view, EmailValidator validator) {
        this.view = view;
        this.validator = validator;
    }

    private void onButtonSignUpClicked(String email, String password, String username) {
        //Your code...
        boolean isValid = validator.isValidEmail(email);
    }
}