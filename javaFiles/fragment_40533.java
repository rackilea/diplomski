try {
   DateTimeFormatter.ofPattern("HH:mm").parse(militaryTime)
}
catch (DateTimeParseException e) {
   System.out.println(militaryTime + " is not a valid military time.");
}