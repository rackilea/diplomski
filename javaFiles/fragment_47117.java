else {
finish();
onAuthSuccess(task.getResult().getUser());
String user_id = auth.getCurrentUser().getUid();
startActivity(new Intent(getApplicationContext(), LoginActivity.class));

 }