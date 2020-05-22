public void onSearchExpand(View view){
    w_SearchBarFullScreen.setVisibility(View.VISIBLE);

   w_SearchBarFullScreen.startAnimation(SearchBarExpand);
   w_Toolbar.startAnimation(FadeOut);

   if(w_SearchBarFullScreen.getVisibility() == View.VISIBLE){
       w_SearchBarFullScreen.requestFocus();
       w_SearchBarFullScreen.setText("   ");
       InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
       assert imm != null;
       imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
   }