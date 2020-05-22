Process cat = Runtime.getRuntime().exec("java -jar C:/cat.jar C:/test.txt");
BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
int read = 0;
byte[] output = new byte[1024];
while ((read = catOutput.read(output)) != -1) {
    System.out.println(output[read]);
}