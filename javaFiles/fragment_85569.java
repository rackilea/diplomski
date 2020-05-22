for (String file : arenaDirectory.list()) {
     if (Stream.of(new File(arenaDirectory, file).list()).filter((childName) -> childName.equals(DATA_FILE_NAME)).count() > 0) {
         File arenaFolder = new File(arenaDirectory, file);
         // code that does something with arenaFolder
     }
}