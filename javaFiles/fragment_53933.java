@JavascriptInterface
public void surf(String memberId){
    // Snipped code //
    final LinearLayout top = (LinearLayout)context.findViewById(R.id.topNav);
    context.runOnUiThread(new Runnable(){
       @Override
       public void run(){
          top.setVisibility(View.VISIBLE);
       }
    });

}