public class DateValueFormatter extends ValueFormatter {

    @Override
    String getFormattedValue(float value) {
        int epochDay = Math.round(value);
        LocalDate date = LocalDate.ofEpochDay(epochDay);
        return date.toString();
    }

}