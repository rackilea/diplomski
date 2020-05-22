emailEditText.getText().toString().matches("")

emailEditText.getText().toString().trim().equals("")

emailEditText.getText().toString().trim().length() > 0

TextUtils.isEmpty( emailEditText.getText().toString()) // .toString(); is not required as @waqaslam pointed out