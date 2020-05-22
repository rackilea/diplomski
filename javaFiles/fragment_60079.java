try {
    FileOutputStream fos = new FileOutputStream("output");
    ObjectOutputStream oos = new ObjectOutputStream(fos);   
    oos.writeObject(MenuArray); // write MenuArray to ObjectOutputStream
    oos.close(); 
} catch(Exception ex) {
    ex.printStackTrace();
}