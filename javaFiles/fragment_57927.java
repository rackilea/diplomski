public class Test {
    public static void main(String[] args) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("a.bin"));
        dos.writeDouble(1.2);
        dos.writeDouble(3.4);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("a.bin"));
        System.out.println(dis.readDouble());
        System.out.println(dis.readDouble());
        dis.close();
    }
}