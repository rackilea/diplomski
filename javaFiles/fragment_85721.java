if ((hour < 0 || hour > 12) || (min < 0 || min > 59) || (!"am".equals(amPm) && !"pm".equals(amPm))) {
    return -1;
}
else if ((hour <= 12 && hour >= 4) && (min <= 59) && ("am".equals(amPm)))  {
    return 1.25;
}
else if ((hour <= 7 && hour >= 5) && (min <= 59) && ("am".equals(amPm))) {
    return 1.4;
}
else if ((hour <= 10 && hour >= 8) && (min <= 59) && ("am".equals(amPm))) {
    return 2.05;
}