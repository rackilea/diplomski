protected void onResume() {
    super.onResume();
    Log.d(TAG,"onResume");
    isSavedInstanceState= false;
    isSavedPrefs= false;
}