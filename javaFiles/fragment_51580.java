public class DeleteCalendarEventsActivity extends ListActivity
{
    private TestAdapter mTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list);

        mTestAdapter = new TestAdapter(this);
        setListAdapter(mTestAdapter);

        refreshList();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        int eventId = mTestAdapter.getItem(position).mId;
        deleteEvent(eventId);
        refreshList();
    }

    private void deleteEvent(int eventId)
    {
        Uri CALENDAR_URI = Uri.parse("content://com.android.calendar/events");
        Uri uri = ContentUris.withAppendedId(CALENDAR_URI, eventId);
        getContentResolver().delete(uri, null, null);
    }

    private void refreshList()
    {
        mTestAdapter.clear();
        for (CalendarEntry calendarEntry : readCalendar())
        {
            mTestAdapter.add(calendarEntry);
        }
    }

    private List<CalendarEntry> readCalendar()
    {
        // Fetch a list of all calendars synced with the device, their title and _id
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.android.calendar/events"),
                (new String[]{"_id", "title"}), "deleted = ?", new String[]{"0"}, null);

        List<CalendarEntry> calendarIds = new ArrayList<CalendarEntry>();

        while (cursor.moveToNext())
        {
            int _id = cursor.getInt(0);
            String title = cursor.getString(1);
            calendarIds.add(new CalendarEntry(_id, title));
        }
        cursor.close();
        return calendarIds;
    }

    static class TestAdapter extends ArrayAdapter<CalendarEntry>
    {
        TestAdapter(Context context)
        {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, null);
            }

            TextView textView = (TextView) convertView;
            textView.setText(getItem(position).mTitle);

            return convertView;
        }
    }

    static class CalendarEntry
    {
        private final int mId;
        private final String mTitle;

        CalendarEntry(int id, String title)
        {
            mId = id;
            mTitle = title;
        }
    }
}