public void setTime (int hour, int minute, int second) {

    if (hour > 0 && hour < 23 ) {
        this.hour = hour;
    } else {
        throw new IllegalArgumentException();
    }

    if (minute > 0 && minute < 59 ) {
        this.minute = minute;
    } else {
        throw new IllegalArgumentException();
    }

    if (second > 0 && second < 59 ) {
        this.second = second;
    } else {
        throw new IllegalArgumentException();
    }       

}