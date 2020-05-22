public class Timer {
int hour;

public int getHour() {
    return hour;
}

public void setHour(int hour) {
    this.hour = hour;
}

public int getMinutes() {
    return minutes;
}

public void setMinutes(int minutes) {
    this.minutes = minutes;
}

public void addDuration(int duration) {
    hour = hour + (minutes + duration)/ 60;
    minutes = (minutes + duration) % 60;
}

int minutes;

@Override
public String toString() {
    int h = (getHour() == 0 || getHour() == 12) ? getHour()
            : getHour() % 24;
    String period = (getHour() < 12) ? "AM" : "PM";
    return String.format("%02d:%02d %s", h, getMinutes(), period);

}

public static void main(String args[]) {
    Timer time = new Timer();
    time.setHour(23);
    time.setMinutes(45);
    System.out.println(time.getHour());
    time.addDuration(30);
    System.out.println(time.getHour());
    System.out.println(time);

}