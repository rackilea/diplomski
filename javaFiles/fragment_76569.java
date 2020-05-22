try {
    fos = new FileOutputStream("M:\\test2.xml");
    bos = new BufferedOutputStream(fos);

} catch (FileNotFoundException ex) {
    System.out.println("File not found. ");
}