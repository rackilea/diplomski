String str = "12/12/2012 5:35 PM"; //Your String containing a date
DateFormat dF = new SimpleDateFormat("dd//MM/yyyy hh:mm a"); // The mask
// 'a' value in the Mask represents AM / PM - h means hours in AM/PM mode
Date date = dF.parse(str); // parsing the String into a Date using the mask

//Date.getTime() method gives you the Long with milliseconds since Epoch.
System.out.println("Epoch representation of this date is: " + date.getTime());