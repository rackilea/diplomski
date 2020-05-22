if (minimum==0 || obj.getValue() < minimum) {
    second = minimum;
    minimum= obj.getValue();
} else if (obj.getValue() < second || second==0) {
    second = obj.getValue();
}