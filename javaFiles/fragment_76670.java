private Bitmap retrieveContactPhoto(String contactID) {

            Bitmap photo = null;

            try {
                InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(),
                        ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, new Long(contactID)));

                if (inputStream != null) {
                    photo = BitmapFactory.decodeStream(inputStream);
                }

                assert inputStream != null;
                inputStream.close();

               return photo ;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }