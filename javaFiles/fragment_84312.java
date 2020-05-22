String fileContent = "";
try {
    fileContent = new String(file.getData());
} catch (ParseException e) {
    e.printStackTrace();
}