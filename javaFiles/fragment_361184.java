NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
numberFormat.setGroupingUsed(false);
ParsePosition pos;
String nString = "4,5.6dfhf";

Number parsed = numberFormat.parse(nString, pos);
if (pos.getIndex() == nString.length()) // pos is set AFTER the last parsed position
   System.out.println("parsed = " + parsed);
else
   // Wrong