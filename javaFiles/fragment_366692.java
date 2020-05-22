public void playerClick(View view) {
    Button B;
    int boardSetIndex;
    int boardSetValue;

    if (view instanceof Button) {
        B = (Button) view;
        if ( noughtsTurn ) {
            B.setText(player.noughtsPlayer());
        } else {
            B = aiPlayerPick();
            System.out.println("AI picked: " + targetIndex);
            B.setText(player.crossesPlayer());
        }
        board.set(boardSetIndex(), boardSetValue());
        System.out.println("Board: " + board);
        B.setEnabled(false);
        //
        if(setTurn(noughtsTurn) == false){
            playNow(findViewByTag(randomButtonPick()))
        }
        //
    }
}