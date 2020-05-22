public class AppointmentDetailSelection extends Activity {

protected Spinner aSpinner;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_appointment_detail_selection);
    aSpinner = (Spinner)findViewById(R.id.spinner);
    DoctorsAdapter adapter = new DoctorsAdapter(this);
    aSpinner.setAdapter(adapter);
    aSpinner.setSelection(0);

}

private class DoctorsAdapter extends ParseQueryAdapter {

        public DoctorsAdapter(final Context context) {
            super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {

                public ParseQuery create() {
                    ParseQuery query = new ParseQuery("Doctors");
                    query.selectKeys(Arrays.asList("Department"));
                    return query;
                }
            });
        }

        public class ViewHolder {
            TextView textView1;
            TextView textView2;
        }

        @Override
        public View getItemView(ParseObject object, View v, ViewGroup parent) {
            ViewHolder holder;
            if (v == null) {
                v = View.inflate(getContext(), R.layout.your_custom_layout, null);
                holder = new ViewHolder();
                holder.textView1 = (TextView)v.findViewById(R.id.textView1);
                holder.textView2 = (TextView)v.findViewById(R.id.textView2);
                v.setTag(holder);
            }
            else
                holder = (ViewHolder)v.getTag();

            holder.textView1.setText(object.getString("field_from_db1"));
            holder.textView2.setText(object.getString("field_from_db2"));

            return v;
        }
    }
}