public class MyDatePicker extends DatePicker {
    public MyDatePicker() {
        super(new DefaultMonthSelector(), new DefaultCalendarView(), new CalendarModel() {
            @Override
            protected DateTimeFormat getMonthAndYearFormatter() {
                return DateTimeFormat.getFormat(PredefinedFormat.YEAR_MONTH);
            }
        });
    }
}