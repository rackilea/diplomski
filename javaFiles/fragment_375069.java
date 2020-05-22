@Override
public void onBackPressed() {
     Intent i = new Intent(SubActivity.this, MainActivity.class);
    i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

    startActivity(i);
}