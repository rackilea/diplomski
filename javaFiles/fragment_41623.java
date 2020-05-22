@Override
public Object getItem(int arg0) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public long getItemId(int arg0) {
    // TODO Auto-generated method stub
    return 0;
}

@Override
public View getView(final int position, View v, ViewGroup arg2) {
    // TODO Auto-generated method stub
    v=inflater.inflate(R.layout.attend_layout, null);
    // Get current value
    String currentAttendent = attendList.Get(position);
    CheckBox box = (CheckBox) v.findViewById(R.id.layout_checkBox);
    // Create TextView
    TextView txt = (TextView) v.findVIewByID(R.id.layout_YourTextViewName) 
    //Set value                                                                      
    txt.SetText(currentAttendent);
    box.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            Toast.makeText(takeAttend, "" + position,Toast.LENGTH_SHORT).show();

        }
    });


    return v;
}

}