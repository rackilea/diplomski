@Override
public void onBackPressed() {
    super.onBackPressed();
    Intent intent = new Intent(getApplicationContext(), ActivityA.class);
    startActivity(intent);
    finish();
}