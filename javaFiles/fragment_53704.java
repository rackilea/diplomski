db.addUser(name, surname, email, uid, created_at, tel_no, home_add, postcode, postal);
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    //Do something after 500ms
    DrawText();
  }
}, 500);