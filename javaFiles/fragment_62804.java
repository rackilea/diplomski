public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    FileOutputStream ostr = new FileOutputStream(new File("ObjectFile.yeh"));
    FileInputStream istr = new FileInputStream(new File("ObjectFile.yeh"));
    ObjectOutputStream out= new ObjectOutputStream(ostr);
    int[] hi = new int[5];
    hi[0]=3;
    out.writeUTF("This is an Array");
    out.writeObject(hi);
    out.reset(); // Add this line
    hi[0]=5;
    out.writeObject(hi);
    out.writeUTF("Array Over");
    out.close();
    ObjectInputStream in = new ObjectInputStream(istr);
    System.out.println(in.readUTF());
    int[] h = (int[]) in.readObject();
    System.out.println(h[0]);
    int[] j = (int[]) in.readObject();
    System.out.println(j[0]);
    System.out.println(in.readUTF());
    in.close();
}