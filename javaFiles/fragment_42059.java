while (curTime <= endTime) {
    for (int k = 0; k < 4 && curTime <= endTime; ++k) {
        dates.add(new Date(curTime));
        curTime += interval;
    }
    for (int k = 0; k < 2 && curTime <= endTime; ++k) {
        curTime += interval;
    }
}