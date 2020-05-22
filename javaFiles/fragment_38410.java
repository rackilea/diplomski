boolean firstRun = getSharedPreferences("preferences", MODE_PRIVATE).getBoolean("firstrun", true);
if(firstRun){
    //set the firstrun to false so the next run can see it.
    getSharedPreferences("preferences", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
    Toast.makeText(getApplicationContext(), "First time to open the app", Toast.LENGTH_SHORT).show();
}
else{
    Toast.makeText(getApplicationContext(), "Not the first time to open it", Toast.LENGTH_SHORT).show();
}