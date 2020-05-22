//The method to start the other activity
public void openMap(View view) {
    Intent intent = new Intent(this, UI_MainActivity.class);
    intent.putExtra("METHOD_TO_CALL", 1); // the 1 is a example, put your ID here
    startActivity(intent);
}