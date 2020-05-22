private int activeIndex = -1;
private int maxIndex = -1;

private void write(int currentIndex, int maxIndex){
    if(maxIndex < currentIndex)
        return;

    activeIndex = currentIndex;
    maxIndex = maxIndex;

    serialPort.writeInt(currentIndex);
}