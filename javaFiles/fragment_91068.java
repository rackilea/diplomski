public class CustomArrayAdapter extends ArrayAdapter<String> {

    int checkAccumulator;

    public CustomArrayAdapter(Context context, String [] Pairs) {
        super(context, R.layout.row_layout1, Pairs);
        checkAccumulator = 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.row_layout1, parent, false);
        String stringelement = getItem(position);
        TextView Text = (TextView) customView.findViewById(R.id.textelement);

        CheckBox checkBox1 = (CheckBox) customView.findViewById(R.id.Checkbox1);
        CheckBox checkBox2 = (CheckBox) customView.findViewById(R.id.Checkbox2);

        CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        countCheck(isChecked);
                        Log.i("MAIN", checkAccumulator + "");
                    }
                };

        checkBox1.setOnCheckedChangeListener(checkListener);
        checkBox2.setOnCheckedChangeListener(checkListener);

        Text.setText(stringelement);
        return customView;
    }

   private void countCheck(boolean isChecked) {

        checkAccumulator += isChecked ? 1 : -1 ;
    }
}