periodDatePicker.init(currentYear, currentMonth, currentDay, new OnDateChangedListener()
{

    @Override
    public void onDateChanged(DatePicker periodDatePicker, int currentYear, int currentMonth,int currentDay) {
        // TODO Auto-generated method stub
        birthDayDatePicker.init(currentYear, currentMonth, currentYear, null);
        birthDateCalculations();
        restartBirthDayDatePickerListener(); 
        // ^here you turn back on that init command that we have just set to null.
    }
});