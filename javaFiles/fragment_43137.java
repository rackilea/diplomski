Intent contactIntent = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,ContactsContract.Contacts.CONTENT_URI);
    contactIntent.setData(Uri.parse("tel:" +"+91"+mMobile));
    contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, name);
    contactIntent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
    contactIntent.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, mobileEx);

    Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.profile_image);

    ArrayList<ContentValues> data = new ArrayList<ContentValues>();

    ContentValues row = new ContentValues();
    row.put(Data.MIMETYPE, ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE);
    row.put(ContactsContract.CommonDataKinds.Photo.PHOTO, bitmapToByteArray(bit));
    data.add(row);
    contactIntent.putParcelableArrayListExtra(Insert.DATA, data);
    startActivity(contactIntent);