List<Date> dates = getDates(date1, date2);
ArrayList<String> dateStringList = new ArrayList<>();

SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

for (Date date : dates) {
    try {
        dateStringList.add(fmt.format(date));
    } catch (ParseException e) {
        e.printStackTrace();
    }

}

dateModel data = new dateModel(dateList);
mReference.child(id).setValue(data);