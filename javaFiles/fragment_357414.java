public void play(int lowerLimit, int upperLimit) {
    instructions(lowerLimit, upperLimit);
    boolean isAboveAverage;
    int counter = howManyTimesHalvable(upperLimit - lowerLimit);
    while (counter > 0) {
        isAboveAverage = isGreaterThan(average(lowerLimit, upperLimit));
        if (isAboveAverage) {
            lowerLimit = average(lowerLimit, upperLimit)+1;
        } else {
            upperLimit = average(lowerLimit, upperLimit);
        }
        if (upperLimit == lowerLimit) {
            break;
        }
        counter--;
    }
    System.out.println("your number is " + upperLimit);
}