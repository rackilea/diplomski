@OnTextChanged(R.id.et_email)
        public void checkCorrectEmail () {
            if (!validateEmail(mEditTextEmail.getText().toString().trim())) {
                isValidated = false;
                mEditTextEmail.setError("Please enter email address");
                mEditTextEmail.requestFocus();
            } else {
                isValidated = true;
                mEditTextEmail.setError(null);
            }
}