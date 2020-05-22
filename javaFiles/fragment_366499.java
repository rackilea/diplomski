FileInputStream fis = new FileInputStream(f);
BufferedReader reader;
try {
    reader = new BufferedReader(new InputStreamReader(fis));
    // once we wrap the fis in a reader, we just close the reader
} finally {
    if (reader != null) {
       reader.close();
    }
    if (fis != null) {
       fis.close();
    }
}