public void setGeraeteStat(final boolean x){
 runOnUiThread (new Runnable() { 
     public void run() {
         if (x==true) {
          gerätestat.setCheckMarkDrawable(android.R.drawable.presence_online);
        } else {
         gerätestat.setCheckMarkDrawable(android.R.drawable.presence_busy);
        }
     }
 });}