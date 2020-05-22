File myFile = new File("pathname");
Long timeMs = myFile.lastModified();
if (timeMs != 0) {
    LocalDateTime date = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(myFile.lastModified()), ZoneId.systemDefault()
    );
    System.out.println(date);
}else{
    System.out.println("File not exist!");
}