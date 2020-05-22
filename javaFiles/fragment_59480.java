public void OnLogin(View view) {
    String username = UsernameEt.getText().toString();
    String password = PasswordEt.getText().toString();
    String type = "login";


    BackgroundWorker backgroundWorker = new BackgroundWorker(this);

    // Set your listener here.
    backgroundWorker.setOnTaskFinishedListener(new BackgroundWorker.OnTaskFinishedListener() {
        @Override
        public void onTaskFinished(String result) {
            // Now you have the result of your login here.
            // Result should be "admin", "user", or "failed"
            // You can now create an intent and open the page 
            // to your next activity.
            switch (result) {
                case "admin":
                    // Create your intent.
                    Intent adminIntent = new Intent(MainActivity.this, AdminPageActivity.class);

                    // Start the admin page activity.
                    startActivity(adminIntent);
                    break;
                case "user":
                    // Create your intent.
                    Intent userIntent = new Intent(MainActivity.this, UserPageActivity.class);

                    // Start the user page activity.
                    startActivity(userIntent);
                    break;
                default:
                    // Login failed.
            }
        }
    });

    backgroundWorker.execute(type, username, password);
}