private void signInOutText() {

        // get menu from navigationView
        Menu menu = navigationView.getMenu();

        // find MenuItem you want to change
        MenuItem nav_signIn = menu.findItem(R.id.signIn);

        //Check if user logged in, change sign in/out button to correct text
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            nav_signIn.setTitle(R.string.sign_out);
        } else {
            nav_signIn.setTitle(R.string.sign_in);
        }
    }