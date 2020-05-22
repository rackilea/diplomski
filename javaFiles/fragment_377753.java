public void onClick(View v) {
    try{
            new Thread(){
                    public void run() {
                        GetStringFromUrl.getString("www.xyz.com");                      
                    }
            }.start();
    }catch(Exception e){
        e.printStackTrace();
    }
}