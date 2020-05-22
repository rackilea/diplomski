public ArrayList<Bills> getDateByUserID(int userID) {
    SQLiteDatabase db = this.getReadableDatabase();
    String tmpcol_monthly_total = "Monthly_Total";
    String tmpcol_month_year = "Month_and_Year";
    String[] columns = new String[]{
            "sum(" + COLUMN_AMOUNT + ") AS " + tmpcol_monthly_total,
            "substr(" + COLUMN_DATE_STRING + ",4) AS " + tmpcol_month_year
    };
    String whereclause = COLUMN_BILL_USER_ID + "=?";
    String[] whereargs = new String[]{String.valueOf(userID)};
    String groupbyclause = "substr(" + COLUMN_DATE_STRING + ",4)";
    String orderbyclause = "substr(" + COLUMN_DATE_STRING + ",7,2)||substr(" + COLUMN_DATE_STRING + ",4,2)";
    ArrayList<Bills> listBillsDates = new ArrayList<Bills>();

    Cursor cursor = db.query(TABLE_BILLS, columns, whereclause,
            whereargs, groupbyclause, null, orderbyclause, null);
    if (cursor.moveToFirst()) {
        do {
            Bills bills = new Bills();
            bills.setAmount(cursor.getInt(cursor.getColumnIndex(tmpcol_monthly_total)));
            bills.setDateString(cursor.getString(cursor.getColumnIndex(tmpcol_month_year))); //<<<<<<<<<< NOTE data is MM/YY (otherwise which date to use? considering result will be arbrirtaryy)
            // Adding record to list
            listBillsDates.add(bills);
        } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();

    // return category list
    return listBillsDates;
}