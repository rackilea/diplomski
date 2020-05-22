boolean skipper = prefs.getBoolean(skip, false);
    if(skipper == true){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);

        Log.i("firstEntry.java","skipped the activity");
        startActivity(i);
}