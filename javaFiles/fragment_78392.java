public void openHomeActivity(User user) {
   Intent homeActivity = new Intent(this, Home.class);
   homeActivity.putExtra(USER_OBJECT, user.getUserId());
   startActivity(homeActivity);
   finish();
}