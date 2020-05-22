private Calendar cal = new GregorianCalendar();

private void skipWeekends(boolean initial) {
    cal.setTime(spinnerModel.getDate());

    switch (cal.get(Calendar.DAY_OF_WEEK)) {
    case Calendar.SATURDAY:
        cal.add(Calendar.DAY_OF_WEEK, initial ? -1 : 2);
        break;
    case Calendar.SUNDAY:
        cal.add(Calendar.DAY_OF_WEEK, -2);
        break;
    }
    spinnerModel.setValue(cal.getTime());
}