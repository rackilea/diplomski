@Override
  protected void onStop(){
  super.onStop();
   }
 // after the OnStop() state


  @Override
  protected void onDestroy() {
  super.onDestroy();
  try {
     trimCache(this);
      } catch (Exception e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
     }
   }