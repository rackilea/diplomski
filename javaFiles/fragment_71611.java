public static void main(String[] args) {
    increment(19, 43, 59);
    increment(23, 59, 59);
    increment(7, 19, 45);
}

public static void increment(int hours, int minutes, int seconds) {
    if (seconds < 59) {
        seconds = seconds + 1;
    } else {
        seconds = 0;
        if (minutes < 59) {
            minutes = minutes + 1;
        } else {
            minutes = 0;
            if (hours < 23) {
                hours = hours + 1;
            } else {
                hours = 0;
            }
        }
    }
    System.out.println(hours + ":" + minutes + ":" + seconds);
}