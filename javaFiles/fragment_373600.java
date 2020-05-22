public void onClick(DialogInterface dialog, int item) {
    switch(item) {
        case 0: // the first item in the CharSequence[]
            callUserClickedNow();
            break;
        case 1: // the second item in the CharSequence[]
            callUserClickedLater();
            break;
        case 2: // the thirditem in the CharSequence[]
            callUserClickedCancel();
            break;
    }
    dialog.dismiss();
}