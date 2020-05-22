File file = new File("input.txt");
System.out.println("" + file.getAbsolutePath());

if (!file.exists()) {
    try {
    file.createNewFile();
    } catch (IOException e) {
    e.printStackTrace();
    }
}