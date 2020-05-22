Properties properties = new Properties();
try {
  properties.load(new FileInputStream("path/filename"));
} catch (IOException e) {
  ...
}