// First, keep track of which index you are using
int index = 2; // initialize it to 2 so that the first time u click the button you get the first text

// loop through
switch (index) {
    case 0:
        // if we are using index 0, set the text to index 1 text and change index to 1
        index = 1;
        ranTx.setText(rangeTx[index]);
    break;
    case 1:
        index = 2;
        ranTx.setText(rangeTx[index]);
    break;
    case 2:
        index = 0;
        ranTx.setText(rangeTx[index]);
    break;
}