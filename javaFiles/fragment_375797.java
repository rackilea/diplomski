private void addPoints(int points) {
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    SharedPreferences.Editor editor = settings.edit();
    editor.putInt("YourScore", (testScore + points));
    editor.commit();       
}

public void onClick(View v) 
{
    switch(v.getId())
    {
    case R.id.Q1A1:
        addPoints(10);
        break;
    case R.id.Q1A2:
        addPoints(5);
        break;
    }   
}