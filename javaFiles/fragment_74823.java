//Check email valid
        if (!isEmailValid(email.getText().toString())) {
            email.setError("Not email type");
            email.requestFocus();
            return;
        }