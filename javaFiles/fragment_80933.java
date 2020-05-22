String string = "RAHUL KUMAR CHOUDHARY:RAJDHANWAR:GIRIDIH:JHARKHAND:825412";
String[] parts = string.split(":");

string = "Name: " + parts[0] + "\n" 
       + "Address: " + parts[1] + "\n"
       + "District: " + parts[2] + "\n"
       + "State: " + parts[3] + "\n"
       + "Pin Code: " + parts[4] + "\n";