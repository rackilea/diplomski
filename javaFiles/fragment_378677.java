public class Test {
    private Calendar calendar;
    public String[] getCurrentWeek() {
        this.calendar = Calendar.getInstance();
        this.calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        this.calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getNextWeek();
    }
    public String[] getNextWeek() {
        DateFormat format = new SimpleDateFormat("M-dd");
        String[] days = new String[7];
        for (int i = 0; i < 7; i++) {
            days[i] = format.format(this.calendar.getTime());
            this.calendar.add(Calendar.DATE, 1);
        }
        return days;
    }
    public String[] getPreviousWeek() {
        this.calendar.add(Calendar.DATE, -14);
        return getNextWeek();
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("Current : " + Arrays.toString(t.getCurrentWeek()));
        System.out.println("Previous: " + Arrays.toString(t.getPreviousWeek()));
        System.out.println("Previous: " + Arrays.toString(t.getPreviousWeek()));
        System.out.println("Next    : " + Arrays.toString(t.getNextWeek()));
        System.out.println("Next    : " + Arrays.toString(t.getNextWeek()));
    }
}