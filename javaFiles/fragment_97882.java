strNationality = (String) countrySpinner.getSelectedItem();
    String data[]=strNationality.split("-");
if(data.length==2)
{
    String countryName=data[0];
    String countryCode=data[1];}