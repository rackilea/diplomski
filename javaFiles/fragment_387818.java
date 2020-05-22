public class RSA {

  public static void main(String args[]) {
    int p = 11, q = 17;
    int n = p * q; //187
    int phi = (p - 1) * (q - 1); //160
    int e = 7, d = 23;

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your message: ");
    String msg = input.nextLine().trim();

    byte[] msgBytes = msg.getBytes();
    byte[] encryptedBytes = new byte[msgBytes.length];

    for (int i = 0; i < msgBytes.length; i++) {
        //below works only because n==187
        encryptedBytes[i] = (byte) (Math.pow(msgBytes[i], e) % n);
    }

    System.out.println("Encrypted string        : " + new String(encryptedBytes));
    System.out.println("Encrypted string base64 : " + new String(Base64.getEncoder().encode(encryptedBytes)));
  }
}