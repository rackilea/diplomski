Runnable scrollBottom = new Runnable() {
    @Override
    public void run() { 
        //This linear is the linearLayout which you added your textView to it 
        LinearLayout playerListView = (LinearLayout) findViewById(R.id.ll);
        playerListView.getChildAt(playerListView.getChildCount()-1).requestFocus();

    }
};