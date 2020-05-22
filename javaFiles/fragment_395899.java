if (times[i] > maxValue) {
    secondLargest = maxValue;
    maxValue = times[i];
} else if (times[i] > secondLargest) {
    secondLargest = times[i];
}