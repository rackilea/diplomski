public void onCompleted(GraphUser user, Response response) {
    TextView welcome = (TextView) findViewById(R.id.welcome);

    if(user != null && welcome != null) {
        welcome.setText("Hello " + user.getName() + "!");
    }
    else {
        // Log it in some way
    }
}