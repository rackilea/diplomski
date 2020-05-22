double device1 = deviceValue(device[0], cost); //note use of [0]
System.out.println("Device 1 total: " + device1);

// CALCULATE THE TOTAL COST OF ANY DEVICE
private static double deviceValue(int[] device, double[] cost) {
    double sumOfDevice = 0;
    for(int i = 0; i < 5; i++) { //also use loop here
        sumOfDevice += device[i] * cost[i];
    }
    return sumOfDevice;
}

private static double deviceValuePlus(int[] device, double[] cost) {
    double deviceX = deviceValue(device, cost);
    double devicePlus= deviceX * 1.10;
    return devicePlus;
}