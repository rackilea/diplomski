public void getDataFromUserSessionService(Context context, String uid) {
Intent intent = new Intent(context, UserSession.class);
intent.setAction(UserSession.ACTION_FETCH_USER_DATA);
intent.putExtra(UserSession.UID, uid);
ServiceToActivity.setSingleton(this,this.getClass());   //create Singleton to store a reference to the activity
context.startService(intent);
}