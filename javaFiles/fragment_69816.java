private Handler handler;

public void onResume(){
    super.onResume();
    if(handler == null){
        handler = new Handler();
        handler.postDelayed(new Runnable() {            
            @Override
            public void run() {
                loadImages();   
            }
        }, 1000);
    }
}

public void onDestroyView(){
    super.onDestroyView();
    handler.removeCallbacksAndMessages(null);
    handler = null;
}