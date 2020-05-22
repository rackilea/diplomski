int numValues = 1000000;
Random random = new Random();
startMeasuringTime();
double result;
for (int i = 0; i < numValues; i++) {
    result = result +
        calculatorInstance.doSomeCalculationsOn(random.nextDouble());
}
stopMeasuringTime();
System.err.println(result);  // Force result to be computed.