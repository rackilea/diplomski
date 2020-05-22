@Override
public void onClick(View v) {
    switch(v.getId()) {
        case R.id.newPuzzleBtn:
            // scramble();
            initializeImages();
            shuffleImageResourceIds();

            //set starting values like before ...

            break;
        default:
           // handle moves like before ...
    }
}