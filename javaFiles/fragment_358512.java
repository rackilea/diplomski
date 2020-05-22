private void createUser() {
        showProgressDialog();
        checkEmailAvailable(inputEmail.getText().toString().trim());
    }

    private void checkEmailAvailable(String email) {
        String whereClause = "email = '" + email + "'";
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause(whereClause);
        Backendless.Persistence.of(BackendlessUser.class).find(dataQuery, new AsyncCallback<BackendlessCollection<BackendlessUser>>() {
            @Override
            public void handleResponse(BackendlessCollection<BackendlessUser> userBackendlessCollection) {
                isAvailable = userBackendlessCollection.getData().isEmpty();
                if (isAvailable){
                    doCreateuser();
                } else {
                    hideProgressDialog();
                    Toast.makeText(CreateAccountActivity.this, BackendSettings.ERROR_EMAIL_TAKEN, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Toast.makeText(CreateAccountActivity.this, backendlessFault.getMessage(), Toast.LENGTH_SHORT).show();
                hideProgressDialog();
            }
        });
    }

    private void doCreateuser(){
        BackendlessUser user = new BackendlessUser();
        user.setProperty(BackendSettings.USERNAME_KEY, inputUsername.getText().toString().trim());
        user.setEmail(inputEmail.getText().toString().trim());
        user.setPassword(inputPassword.getText().toString());

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                hideProgressDialog();
                Toast.makeText(CreateAccountActivity.this, BackendSettings.REGISTER_SUCCESS_MESSAGE, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                hideProgressDialog();
                String errorCode = backendlessFault.getCode();
                String errorMessage;
                switch (errorCode) {
                    case "3040":
                        errorMessage = BackendSettings.ERROR_3040;
                        break;
                    case "3033":
                        errorMessage = BackendSettings.ERROR_3033;
                        break;
                    default:
                        errorMessage = "An unknown error occurred. Try again.";
                }
                Toast.makeText(CreateAccountActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }