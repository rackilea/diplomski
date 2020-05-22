public class Time {

    public static void main(String[] args) {
        Time time = new Time();
        time.advance(90);

        System.out.println(time);
    }

    private Calendar cal;

    public Time() {
        cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
    }

    public Time(int hours, int minutes) {
        this();
        cal.set(Calendar.HOUR, hours);
        cal.set(Calendar.MINUTE, minutes);
    }

    public void advance(int aminutes) {
        cal.add(Calendar.MINUTE, aminutes);
    }

    @Override
    public String toString() {
        String time = cal.get(Calendar.HOUR_OF_DAY) + " " + cal.get(Calendar.MINUTE);
        return time;
    }
}