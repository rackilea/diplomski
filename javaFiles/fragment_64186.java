checkInformation();
if(mSwitch) {
    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
    saveUserInformation();
    startActivity(intent);
}