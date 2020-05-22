double normalize(double value, double min, double max) {
    return (value - min) / (max - min);
}

int clamp(int value, int min, int max) {
    if (value < min) value = min;
    if (value > max) value = max;
    return value;
}

int discretize(double value, double min, double max, int binCount) {
    int discreteValue = (int) (binCount * normalize(value, min, max));
    return clamp(discreteValue, 0, binCount - 1);
}

public int discretizeObservation(Observation observation ) {
    int position = discretize(observation.getDouble(0), minPosition, maxPosition, positionBinCount);
    int velocity = discretize(observation.getDouble(1), minVelocity, maxVelocity, velocityBinCount);
    return position * velocityBinCount + velocity;
}