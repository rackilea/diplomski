@Override
public  void onDestroy(){
    if(theGraceCountDownTimer!=null)
    theGraceCountDownTimer.cancel();
    theFirstCountDownTimer.cancel();
    super.onDestroy();
}