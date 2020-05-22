String line = in.nextLine();
String[] parts = line.split(";");
if(parts[1].equals("Conference")) {
    conferenceTotal += Double.parseDouble(parts[2]);
} else if(parts[1].equals("Dinner")) {
    dinnerTotal += Double.parseDouble(parts[2]);
} else if(parts[1].equals("Lodging")) {
    lodgingTotal += Double.parseDouble(parts[2]);
}