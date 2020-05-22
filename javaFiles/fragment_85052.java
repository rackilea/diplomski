switch (switchDoor) {

case 1: {

    if (compChoice == prizeIs) {
        noSwitch++;
        wins++;
        games++;
    }
    else {
        games++;
        switches++;  //This should be added, game incremented but switch or noswitch can not. 50% time may this happens.
                    // If we chose no Switch and loose that means switches should be right choice and get incremented.

    }
}
    break;

case 2: {
    if (compChoice == prizeIs) {
        games++;
        noSwitch++; //Same as previous logic
    }
    else if (compChoice != prizeIs) {

        switches++;
        wins++;
        games++;
    }

}