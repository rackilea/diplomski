public void onGenericMenuClick(View view) {
    Intent intent;

    if(v.getId() == R.id.pasttests) {
        intent =  new Intent(this, PastDiagnosticResult.class);
    } else if (v.getId() == R.id.myinfo) {
        intent =  new Intent(this, UserDataInputActivity.class);
    } else if (v.getId() == R.id.currenttest) {
        intent =  new Intent(this, CurrentDiagnosticResultActivity.class);
    }

    startActivity(intent);
}