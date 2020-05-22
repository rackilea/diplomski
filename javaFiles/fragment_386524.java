@Override
public void onBackPressed() {
    Intent i = new Intent(this, SignInActivity.class);
    finishAffinity();
    startActivity(i);
}