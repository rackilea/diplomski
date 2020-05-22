@Override
public void onClick(View v) {

    String stringName = "";

    ArrayList<Country> countryList = dataAdapter.countryList;

    for(int i=0;i<countryList.size();i++){
        Country country = countryList.get(i);
        if(country.isSelected()){
            stringName = (stringName + country.getName());

            // ---------The problem is here: 
            // This code is unreachable when none of the checkboxes is checked               

            TextView t = ((TextView)findViewById(R.id.textView1));
            t.setText(stringName);
        }
    }
}