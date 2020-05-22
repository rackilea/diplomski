item = new ItemFolderP(
    Integer.toString(mRow.getInt(mRow.getColumnIndex("Id"))),
    mRow.getString(mRow.getColumnIndex("test")),
    mRow.getString(mRow.getColumnIndex("code")),
    mRow.getString(mRow.getColumnIndex("price")),
    mRow.getString(mRow.getColumnIndex("url")));