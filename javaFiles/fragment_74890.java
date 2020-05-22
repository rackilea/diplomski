private boolean interactionEnabled = true; // code added
public void switchImage(int position, View view){
    if (!interactionEnabled) return; // code added
     //... your code here

    else{
        interactionEnabled = false; // code added
        Handler mHandler = new Handler(); 
        mHandler.postDelayed(update, 2000);
    }                  
}

private Runnable update = new Runnable() {
    public void run() {
         viewHolder[0].setImageResource(R.drawable.card_back);
         viewHolder[1].setImageResource(R.drawable.card_back);
         interactionEnabled = true; // code added
    }
};