int nextFitness(int fitness, Object[][] timetable) {
    for (Object[] day : timetable)                        // "on the same day"
        for (int hour = 0; hour < Main.hours - 1; hour++) // "consecutive"
            if (Objects.equals(day[hour], day[hour + 1])) // "equal"
                fitness -= 100;                           // "i need to do this"
    return fitness;
}