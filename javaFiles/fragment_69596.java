import java.util.Arrays;

public static void main(String[] args) {
    BufferedImage img = null;

    try {
        img = ImageIO.read(new File("a.jpg"));
    } catch (IOException ex) {

    }

    int pixel[] = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
    int[] newpixel = Arrays.copyOf(pixel, pixel.length);

    String s = "abc";
    byte[] b = s.getBytes();

    int count = 0;
    for (int i = 0; i < b.length; i++) {
        byte current_byte = b[i];
        for (int j = 7; j >= 0; j--) {
            int lsb = (current_byte >> j) & 1;
            newpixel[count] = (pixel[count] & 0xfffffffe) + lsb;
            System.out.println(lsb + ":(" + pixel[count] + "," + newpixel[count] + ")");
            count++;
        }
    }

    // Extraction sequence
    String secret = "";
    int bit = 0;
    for (int i = 0; i < b.length; i++) {
        int ascii = 0;
        for (int j = 7; j >=0; j--) {
            ascii += (newpixel[bit] & 1) << j;
            bit++;
        }
        secret += (char)ascii;
    }
    System.out.print(secret);

}