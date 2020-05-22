File f = new File("C:/Users/Matthew/Desktop/hello.txt");
URL url1;
try {
    url1 = new URL(url);
    IOUtils.copy(url1.openStream(), new FileOutputStream(f, true));
} catch (MalformedURLException e1) {
    e1.printStackTrace();
} catch (IOException e1) {
    e1.printStackTrace();
}