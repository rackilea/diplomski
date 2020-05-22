EditText[] nasteEdit = new EditText[]{ /* your seven instance of editText for naste value in correct order */};
List<Day> days = mDatabase.getAllDaysByWeek(week.getTitle());

int cntDays = 0;
for (Day day : days) {
    String getNasteMonday = nasteEdit[cntDays] != null ? nasteEdit[cntDays].getText().toString() : null;
    double nasteValue = convertStringToDouble(getNasteMonday);
    day.setNaste(nasteValue);

    // SAME FOR OTHER ATTRIBUTE
    mDatabase.updateDay(day);

   cntDays++;
}