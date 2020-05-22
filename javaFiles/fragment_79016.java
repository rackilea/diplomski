public class A {
    public static void main(String[] args) {
        int[] ip = new int[] {192, 168, 101, 23};
        byte[] ipb = new byte[4];
        for (int i =0; i < 4; i++) {
            ipb[i] = (byte)ip[i];
        }

        for (int i =0; i < 4; i++) {
            System.out.println("Byte: " + ipb[i] + ", And: " + (0xff & ipb[i]));
        }
    }
}