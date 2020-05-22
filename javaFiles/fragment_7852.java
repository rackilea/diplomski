public void showDailyTodo() {
Date d = new Date();
SimpleDateFormat df = new SimpleDateFormat("dd.mm.yyyy");
String formattedDate = df.format(d);
if(dueDate.equals(formattedDate)) {
    // code that listview items with duedate today are shown.
}
}