String time_out = "9:45:21"; // starting time
String[] parts = time_out.split(":"); // split into 3 parts
parts[0] = Integer.toString(Integer.parseInt(parts[0]) + 2); // add two to hours

String new_time_out = parts[0]+":"+parts[1]+":"+parts[2]; // recreate string        
System.out.println(new_time_out);