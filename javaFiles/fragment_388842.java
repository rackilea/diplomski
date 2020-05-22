public void onItemSelected(AdapterView<?> adapterView, View view,int position, long arg3) 
{
    if(!spinner.getSelectedItem().toString().equalsIgnoreCase("Select Country"))
    {
          selectedCountry.setText(spinner.getSelectedItem().toString());  
    }
}