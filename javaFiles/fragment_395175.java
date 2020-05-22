SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
int oldScore = prefs.getInt("key", 0);  
if(newScore > oldScore ){
   Editor edit = prefs.edit();
   edit.putInt("key", newScore);
   edit.commit();
}