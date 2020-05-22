private static final int UPCOMING_COUNT = 10;


public static List<BContact> upcomingBirthday(Context ctx) {
    String today = new SimpleDateFormat("MM-dd").format(new Date());        
    List<BContact> firstPart = upcomingBirthday(ctx, today, "12-31", UPCOMING_COUNT);
    if (firstPart.size() < UPCOMING_COUNT) {
        firstPart.addAll(upcomingBirthday(ctx, "01-01", today, UPCOMING_COUNT - firstPart.size()));
    }
    return firstPart;
}


public static List<BContact> upcomingBirthday(Context ctx, String fromDate, String toDate, int rows) {

  Uri dataUri = ContactsContract.Data.CONTENT_URI;

  String[] projection = new String[] { ContactsContract.Contacts.DISPLAY_NAME,                         
            ContactsContract.CommonDataKinds.Event.CONTACT_ID,
            ContactsContract.CommonDataKinds.Event.START_DATE
            };


  Cursor c = ctx.getContentResolver().query(
       dataUri,
       projection, 
       ContactsContract.Data.MIMETYPE + "= ? AND " + 
       ContactsContract.CommonDataKinds.Event.TYPE + "=" + ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY + 
       " AND substr(" + ContactsContract.CommonDataKinds.Event.START_DATE + ",6) >= ?" + 
       " AND substr(" + ContactsContract.CommonDataKinds.Event.START_DATE + ",6) <= ?" ,
       new String[] {ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE, fromDate, toDate}, 
       "substr("+ ContactsContract.CommonDataKinds.Event.START_DATE +",6)");
  List<BContact> result = new ArrayList<BContact>();
  int i=0;
  while (c.moveToNext() && i<rows) {
      result.add(new BContact(c.getString(0), c.getString(1), c.getString(2)));
      i++;
  }
  c.close();
  return result;