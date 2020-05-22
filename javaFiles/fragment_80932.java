String string = "NAME-RAHUL KUMAR CHOUDHARY ADDRESS-RAJDHANWAR DISTRICT-GIRIDIH STATE-JHARKHAND PIN CODE-825412";
String[] parts = string.split("-");

string = "Name: " + parts[1].substring(0, parts[1].length() - 7) 
       + "\nAdress: " + parts[2] + " - " + parts[3]
       + "\nPin Code: " + parts[5];