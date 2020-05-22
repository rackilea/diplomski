public List<SignUpPOJO> fetchLoginDetails(String value) {
        this.open();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GET_USER_PASS + "'" + value + "'", null);
        List<SignUpPOJO> list = new ArrayList<SignUpPOJO>();
        // while (cursor.moveToFirst()) {
        // do {
        cursor.moveToNext();
        SignUpPOJO pojo = new SignUpPOJO();
        pojo.setName(cursor.getString(0));
        pojo.setPassword(cursor.getString(1));
        list.add(pojo);
        // } while (cursor.moveToNext());
        cursor.close();
        db.close();
        // }
        return list;
    }