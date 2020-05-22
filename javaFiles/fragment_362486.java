public class BookHour {

private int hours;
private int minutes;

BookHour(String formatedTime) {
    final String[] split = formatedTime.split(":");
    this.hours = Integer.valueOf(split[0]);
    this.minutes = Integer.valueOf(split[1]);
}

public int getHours() {
    return hours;
}

public int getMinutes() {
    return minutes;
}

public void setNextQuater() {
    // logic with changing hour and minutes
}
}