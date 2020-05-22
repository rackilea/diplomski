if (getSharedPreferences("purchased", 0).getBoolean("purchased",false) == false) {
   admob();        
   Log.d("NOT UPGRADED", "SHOW AD AS UPGRADED ALREADY");
} else if (getSharedPreferences("purchased", 0).getBoolean("purchased",true) == true) {
   admobskip();    
   Log.d("UPGRADED", "DO NOT SHOW AD AS UPGRADED ALREADY");
}