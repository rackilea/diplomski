File directory = getFilesDir(); //or getExternalFilesDir(null); for external storage
File file = new File(directory, fileName);

FileOutputStream fos = null;
try {
    fos = new FileOutputStream(file);
    fos.write(IDNum.getBytes());
    fos.close();
} catch (IOException e) {
    e.printStackTrace();
}