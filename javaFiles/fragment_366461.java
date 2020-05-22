public List<WeekDay> getListOfWeeksFromListOfDates(List<Date> listOfDates) {
    List<WeekDay> listOfWeeks = new ArrayList<>();
    WeekDay weekDay;
    for (Date date : listOfDates) {
        weekDay = new WeekDay(date, new SimpleDateFormat("w").format(date));
        listOfWeeks.add(weekDay);
    }

    return listOfWeeks;
}


public class WeekDay {

    Date date;
    String weekIdentifier;

    public WeekDay(Date Date, String WeekIdentifier) {
        this.date = Date;
        this.weekIdentifier = WeekIdentifier;
    }

    public Date getDate() {
        return date;
    }

    public String getWeekIdentifier() {
        return weekIdentifier;
    }

}