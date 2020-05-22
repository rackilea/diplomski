public class Test {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
        double[] a = {1.2, 3.4};
        oos.writeObject(a);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.bin"));
        double[] b = (double[]) ois.readObject();
        System.out.println(b[0]);
        System.out.println(b[1]);
        ois.close();
    }
}