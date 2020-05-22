moveDirectory.setOnClickListener(new OnClickListener(){
    public void onClick(View v)
    {
        try{
            Process send = Runtime.getRunetime().exec(new String[] {"cd /sdcard/music/ ; cp pic1 /sdcard/pic1"});
        } catch (Exception ex){
            String toast = null;
            Log.i(toast, "Couldn't copy file", ex);
            }
        }
    });