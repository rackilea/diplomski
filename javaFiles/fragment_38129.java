try {
    mGpsModule = new NmeaGpsModule(
           "UART0", 9600, 1.8f);
    ...

} catch (IOException e) {
    // couldn't configure the gps module...
}