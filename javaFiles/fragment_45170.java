java.time.format.DateTimeFormatter target2 = 
     java.time.format.DateTimeFormatter.ofPattern("h:mm a");
java.time.format.DateTimeFormatter source2 = 
     java.time.format.DateTimeFormatter.ofPattern("HH:mm");

System.out.println("01:30 -> " + target2.format(source2.parse("01:30")));
System.out.println("21:20 -> " + target2.format(source2.parse("21:20")));