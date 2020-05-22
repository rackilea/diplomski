ProgressDialog pd;
private final Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        switch(msg.what){
         case 1:
            pd = ProgressDialog.show(this, "uploading...", "Please Wait..", true,false);
            pd.setCancelable(false);

          break;
         case 2:
         pd.dismiss();
         break;
        }

}
};
 new Thread(new Runnable() {                
            @Override
            public void run() {                     
                try {                   
                         handler.sendEmptyMessage(1);
                         executeMultipartPost(bitmap,filename.jpg);
                         handler.sendEmptyMessage(2);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }   

            }
        }).start();