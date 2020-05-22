Cursor contactCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null, null, null);
contactCursor.moveToFirst();
do {
            String num = contactCursor.getString(contactCursor
                    .getColumnIndex(CommonDataKinds.Phone.NUMBER));
            acontactslist.add(num);
            }
        } while (contactCursor.moveToNext());

phonenumber.setAdapter(acontactslist);