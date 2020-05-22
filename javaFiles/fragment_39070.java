Date              d;
SimpleDateFormat  sdf;
String            s;

d = dateChooser.getDate();                      // Date selected by user
sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  // Or whatever format you need
s = sdf.format(d);                              // Viola