public View getView(int position, View convertView, ViewGroup parent) {

...
final Skill s = (Skill) getItem(position);

if (convertView == null) {
    LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = li.inflate(R.layout.yourlayout, null);
} else {
  // use cached view
}

Button buttonInc = (Button) convertView.findViewById(R.id.buttonInc);
buttonInc.setOnClickListener(new View.OnClickListener() {
         public boolean onClick(View v) {
                // call to your core class to increase your data (skill object),    
                // preferable using AsyncTask.
         });


Button buttonDec = (Button) convertView.findViewById(R.id.buttonDec);
buttonDec.setOnClickListener(new View.OnClickListener() {
         public boolean onClick(View v) {
                // call to your core class to decrease your data (skill object),
                // preferable using AsyncTask.
         });

....
return convertView;
}