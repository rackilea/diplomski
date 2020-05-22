//DELETE ELEMENT FROM FOLDER
Path imagesPath = Paths.get(
    "/Computer/NetBeans IDE 8.2/NewDataBase/src/newdatabase/images/" +
    pictureName);

try {
    Files.delete(imagesPath);
    System.out.println("File "
            + imagesPath.toAbsolutePath().toString()
            + " successfully removed");
} catch (IOException e) {
    System.err.println("Unable to delete "
            + imagesPath.toAbsolutePath().toString()
            + " due to...");
    e.printStackTrace();
}