public void serialEvent(SerialPortEvent event) {
    if (event.isRXCHAR() && event.getEventValue() > 0) {
        .....

        write(activeIndex + 1, maxIndex);
    } 
}