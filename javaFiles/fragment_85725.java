if (parametersAreInvalid(hour, min, amPm)) {
    return -1;
}

if ("am".equals(amPm)) {
    if (hour <= 10 && hour >= 8) {
        return 2.05;
    }

    if (hour <= 7 && hour >= 5) {
        return 1.4;
    }

    if (hour >= 4)  {
        return 1.25;
    }
}