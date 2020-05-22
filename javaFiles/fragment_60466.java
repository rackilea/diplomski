//"caused" the problem
private double percentageOfDay(Time time) {
    //factor the hour
    double percentage = time.hour / 24f;
    //factor the minute
    percentage += time.minute / 1440f;
    //factor the second
    percentage += time.second / 86400f;     

    return percentage;
}

//This fixed the problem
private double percentageOfDay(Calendar cal) {
    //factor the hour
    double percentage = cal.get(Calendar.HOUR) / 24f;
    //factor the minute
    percentage += cal.get(Calendar.MINUTE) / 1440f;
    //factor the second
    percentage += cal.get(Calendar.SECOND) / 86400f;
    //factor the millisecond
    percentage += cal.get(Calendar.MILLISECOND) / 86400000f;

    return percentage;
}