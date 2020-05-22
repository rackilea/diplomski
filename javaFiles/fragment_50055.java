File file = //...
try(OutputStream outputStream = new FileOutputStream(file)){
    IOUtils.copy(inputStream, outputStream);
} catch (FileNotFoundException e) {
    // handle exception here
} catch (IOException e) {
    // handle exception here
}