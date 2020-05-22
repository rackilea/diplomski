if(res.equals("5510")){
    checkback.setText("Correct version");
    Intent i = new Intent(CurrentActiviy.this, mainactivity.class);
        startActivity(i);
}else{
    checkback.setText("Incorrect version, please update. \n Your current version is " + getString(R.string.versioncode));
}