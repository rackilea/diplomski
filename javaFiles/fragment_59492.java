ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                    .withValue(Data.RAW_CONTACT_ID, ContactId)
                    .withValue(Data.MIMETYPE, Nickname.CONTENT_ITEM_TYPE)
                    .withValue(Nickname.NAME, "Sister")
                    .withValue(Nickname.TYPE, Nickname.TYPE_CUSTOM)
                    .withValue(Nickname.LABEL, "Sister")
                    .build());
                getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);