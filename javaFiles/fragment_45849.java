public class view_items_CursorAdapter extends CursorAdapter {
 boolean[] checkbox;
 public view_items_CursorAdapter(Context context, Cursor cursor, int flags)      
{
    super(context, cursor, 0);
    checkbox = new boolean[cursor.getCount()];
}


@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    return LayoutInflater.from(context).inflate(R.layout.act_view_items_view, parent, false);
}


@Override
public void bindView(View view, Context context, Cursor cursor) {

    final int position = cursor.getPosition();
    TextView tvBody = (TextView) view.findViewById(R.id.workout_items_textView);
    TextView tvPriority = (TextView) view.findViewById(R.id.workout_items_textView2);
    CheckBox tvCheck = (CheckBox) view.findViewById(R.id.checkbox1);

    String body = cursor.getString(cursor.getColumnIndexOrThrow("task"));
    int priority = cursor.getInt(cursor.getColumnIndexOrThrow("reps"));

    tvBody.setText(body);
    tvPriority.setText(String.valueOf(priority));
    tvCheck.setChecked(checkbox[position]);
    tvCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
         checkbox[position] = isChecked;
       }});
}