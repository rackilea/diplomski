public class MySimpleArrayAdapter extends ArrayAdapter<Item>
{
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.listitem, parent, false);
        CheckBox checkBox = (CheckBox)rowView.findViewById(R.id.checkBox);
        TextView newwordview = (TextView)rowView.findViewById(R.id.newwordview);

        Item item = getItem(position);
        newwordview.setText(item.title);
        checkBox.setChecked(item.checked);


        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked)
            {
                Item item = getItem(position);
                item.checked = isChecked;
            }
        });

        return rowView;
    }
}