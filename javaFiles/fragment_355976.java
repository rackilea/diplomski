mCalander.set(Calendar.YEAR, 2017);
mCalander.set(Calendar.MONTH, 0);
int totalMonths = mCalander.getActualMaximum(Calendar.MONTH);
for (int j = 0; j <= totalMonths; j++) {
    Log.d("INFO", "MONTH : " + j);
    int maxDay = mCalander.getActualMaximum(Calendar.DAY_OF_MONTH);
    mCalander.set(Calendar.DAY_OF_MONTH, 1);
    for (int k = 1; k <= maxDay; k++) {
        Log.d("INFO", k + " - " + mDf.format(mCalander.getTime()));
        mCalander.add(Calendar.DAY_OF_MONTH, 1);
    }
}