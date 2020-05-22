if(number.length()==7) {
    cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, 
        ContactsContract.CommonDataKinds.Phone.NUMBER+" LIKE ?",
        //"('%" + ContactsContract.CommonDataKinds.Phone.NUMBER+"' LIKE '?' AND LENGTH("+ContactsContract.CommonDataKinds.Phone.NUMBER+")=7) OR ('" + ContactsContract.CommonDataKinds.Phone.NUMBER+"' LIKE '%?' AND LENGTH("+ContactsContract.CommonDataKinds.Phone.NUMBER+")=10)",
        new String[] { "%"+number },
        null);
} else if(number.length()==10) {
    cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, 
        "("+ContactsContract.CommonDataKinds.Phone.NUMBER+"=? AND LENGTH("+ContactsContract.CommonDataKinds.Phone.NUMBER+")=7) OR ("+ContactsContract.CommonDataKinds.Phone.NUMBER+"=? AND LENGTH("+ContactsContract.CommonDataKinds.Phone.NUMBER+")=10)",
        new String[] { number.substring(3), number },
        null);
} else {
    cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, 
        ContactsContract.CommonDataKinds.Phone.NUMBER+"=?",
        new String[] { number },
        null);
}