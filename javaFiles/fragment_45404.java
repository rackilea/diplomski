case R.id.fetch1:
Cursor cursor = openHelper.getRecords();
    StringBuffer sb = new StringBuffer();
    while(cursor.moveToNext()) {
        sb.append(cursor.getString(0) + "\n");
    }
tv.setText(sb.toString);
break;