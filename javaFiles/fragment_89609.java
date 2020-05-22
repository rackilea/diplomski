final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    FirebaseDatabase.getInstance().getReference()
            .child("node_name").child(keyval).removeValue()
  }
}, 60000);