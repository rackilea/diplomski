public class RunAdapter extends SimpleAdapter {

public RunAdapter(Context context, List<HashMap<String, String>> items,
        int resource, String[] from, int[] to) {
    super(context, items, resource, from, to);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view = super.getView(position, convertView, parent);
    TextView txtView = (TextView) view.findViewById(R.id.lstTurnout);
        if (txtView.getText().toString().contains("BLU")) {
            txtView.setBackgroundColor(Color.rgb(0x00, 0x00, 0xaa));
            txtView.setText(txtView.getText().toString().replace("BLU", ""));
        } else {
            txtView.setBackgroundColor(Color.rgb(0xaa, 0x00, 0x00));
            txtView.setText(txtView.getText().toString().replace("RED", ""));
        }
  }