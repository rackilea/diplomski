DateFormatSymbols symbols = new DateFormatSymbols(new Locale("it"));
// for the current Locale :
//   DateFormatSymbols symbols = new DateFormatSymbols(); 
String[] dayNames = symbols.getShortWeekdays();
for (String s : dayNames) { 
   System.out.print(s + " ");
}
// output :  dom lun mar mer gio ven sab