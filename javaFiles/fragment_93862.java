Object value = jSpinner2.getValue();
if (value instanceof Date) {
    String time = new SimpleDateFormat("HH:mm").format(value);
    t1.setHourBegin(time);
} else {
    // Deal with the invalid value...
}