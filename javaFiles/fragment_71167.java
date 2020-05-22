public void onClick(View v) {

    if(!((Button) v).getText().toString().equals("")){
        return;
    }

    ((Button) v).setText("0");
    turn();

    // Need a pause before tictacAI does anything
    v.postDelayed(new Runnable() {
        @Override
        public void run() {
            tictacAI("0", "X").setText("X");
            turn();
            if(won){
                resetBoard();
                won = false;
            }
        }
    }, 1000L); //wait 1 second
}