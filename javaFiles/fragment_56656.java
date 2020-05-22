public static boolean updateMail(Context context, String id, String email){
        ContentProviderOperation.Builder builder;
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();

        if (getMailById(context, id).isEmpty()){
            builder = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            builder.withValue(ContactsContract.Data.RAW_CONTACT_ID, getRawId(context, Long.parseLong(id)));
            builder.withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
            builder.withValue(ContactsContract.CommonDataKinds.Email.ADDRESS, email);
            ops.add(builder.build());
        } else {
            builder = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);

            builder.withSelection(ContactsContract.Data.CONTACT_ID + "=? " + "AND "
                            + ContactsContract.CommonDataKinds.Organization.TYPE + "=?"
                    , new String[]{id,
                            String.valueOf(ContactsContract.CommonDataKinds.Email.TYPE_HOME)});
            builder.withValue(ContactsContract.CommonDataKinds.Email.ADDRESS, email);
            ops.add(builder.build());

        }

        return (applyBatch(context, ops));
    }