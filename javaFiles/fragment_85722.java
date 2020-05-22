if (parametersAreInvalid(hour, min, amPm)) {
    return -1;
}

if ((hour <= 12 && hour >= 4) && (min <= 59) && "am".equals(amPm))  {
    return 1.25;
}

if ((hour <= 7 && hour >= 5) && (min <= 59) && "am".equals(amPm)) {
    return 1.4;
}

if ((hour <= 10 && hour >= 8) && (min <= 59) && "am".equals(amPm)) {
    return 2.05;
}