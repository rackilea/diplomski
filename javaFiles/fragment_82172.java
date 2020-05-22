SharedPreferences mysettings = PreferenceManager.getDefaultSharedPreferences(this);
String st1 = mysettings.getString("MEASURE_KEY", "default Value here");

if(st1.equals("Inches-Pounds")){ 
    //do some stuff here
    //like textview.setText.....
}
if(st1.equals("Cm-Kilograms")){ 
    //do some stuff here
}