@Override
public void onStop() {
    super.onStop();
    if(timerTask != null){
        timerTask.cancel();
        //cancel timer task and assign null
    }
}