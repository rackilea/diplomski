public static int GuessMachine(int InputNumber, int rndNumber) {
    int value = InputNumber;
    int randomNumber = rndNumber;
    count = count + 1;
    if (InputNumber == randomNumber) {
        // count +=1; No need for this statement anymore because we moved it out.
        ...