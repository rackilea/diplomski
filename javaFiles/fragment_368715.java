@NotEmpty
@Order(1)
private EditText fieldEditText;

@Checked(message = "You must agree to the terms.")
@Order(2)
private CheckBox iAgreeCheckBox;

@Length(min = 3, message = "Enter atleast 3 characters.")
@Pattern(regex = "[A-Za-z]+", message = "Should contain only alphabets")
@Order(3)
private TextView regexTextView;

@Password
@Order(4)
private EditText passwordEditText;

@ConfirmPassword
@Order(5)
private EditText confirmPasswordEditText;