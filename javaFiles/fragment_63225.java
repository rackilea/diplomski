if (getCursor != null) {
    while (getCursor.moveToNext()) {
      columnIndex = getCursor.getColumnIndexOrThrow(projection[0]);  
      imageCollection.add(String.valueOf(getCursor.getLong(columnIndex));
    }
 }