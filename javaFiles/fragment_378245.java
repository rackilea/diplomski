public void onDateSet(DatePicker datePicker, int nYear, int nMonth, int nDay) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
    calendar.set(nYear, nMonth, nDay);
    String dateString = sdf.format(calendar.getTime());
    tvDate.setText(dateString);
}