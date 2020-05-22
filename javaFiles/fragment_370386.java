// your code looks good if textview is inside GridView;
This code is for textview outside:

ExtendedCalendarView extendedCalendarView = (ExtendedCalendarView) findViewById(R.id.calendar);
GridView calendar = (GridView) extendedCalendarView.findViewById(999);
TextView dayTV = (TextView) findViewById(R.id.textView1);

calendar.setOnItemClickListener(new OnItemClickListener() {
@Override
public void onItemClick(AdapterView adapter, View view, int pos,long id) {
dayTV.setBackgroundResource(R.drawable.ic_launcher);
} 
}