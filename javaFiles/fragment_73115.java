int index = cursor.getColumnIndexOrThrow("AUTHOR_EMAIL");
if (cursor.isNull(index)) {
    ...
} else {
    String authEmail = cursor.getString(index);
    ...
}