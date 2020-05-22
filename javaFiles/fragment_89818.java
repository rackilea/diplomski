@Override
public void onResumeAndShowFragment() {
    amIVisible=true;


    if(dataList!=null && dataList.size()==0){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Load data from net if data was not found,
                //This basically means auto refresh when user scrolls back and the fragment had no data
            }
        },400);
    }
}

@Override
public void onPauseAndHideFragment() {
    amIVisible=false;
}