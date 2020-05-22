public Time getEnd() {
    Time endTime;
    startTime.addMinutes(minutes);
    //This seems wrong, by the way.  startTime will be modified by this call.
    endTime = startTime;
    return endTime;
}