if (parametersAreInvalid(hour, min, amPm)) {
    return -1;
}

if ((hour <= 10 && hour >= 8) && "am".equals(amPm)) {
    return 2.05;
}

if ((hour <= 7 && hour >= 5) && "am".equals(amPm)) {
    return 1.4;
}

if (hour >= 4 && "am".equals(amPm))  {
    return 1.25;
}