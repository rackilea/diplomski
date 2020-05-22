@Override
public void onBackPressed() {

    finish();
    Intent intent = new Intent(Myactivity.this, other.class);
    startActivity(intent);
}