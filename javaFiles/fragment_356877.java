try {
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(jsonObject.toString());
    fileWriter.flush();
} catch (Exception e) {
    e.printStackTrace();
}