private int lastStartNumber = 0;

private int getNextStartNumber(){
    lastStartNumber = lastStartNumber + 1;
    return lastStartNumber;
}