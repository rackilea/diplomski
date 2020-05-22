@Override
public void onDateSet(DatePicker view, int year, int month, int day) {
    String date = day + "-"+(month+1)+"-"+year;

    if (mPDInterface != null) {
        mPDInterface.onDateSet(date);
    }
}