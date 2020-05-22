Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(id));
 InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(cr, my_contact_Uri, true);
 BufferedInputStream buf = new BufferedInputStream(photo_stream);
 Bitmap my_btmp = BitmapFactory.decodeStream(buf);
 buf.close();
 return my_btmp;