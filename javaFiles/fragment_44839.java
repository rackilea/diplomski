@Override
public void onBackPressed() {
    Intent intent = new Intent(getApplicationContext(), Welcome.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
}