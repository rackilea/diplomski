@Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.v("onPause()", "super.onPause()");
        v.pause();  //V IS AN OBJECT OF THE CLASS OurView

    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.v("onResume()", "super.onResume()");
        v.resume();
      }