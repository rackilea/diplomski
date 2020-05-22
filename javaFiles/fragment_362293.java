import java.nio.charset.StandardCharsets;

class Z {
     public static void main(String[] args) {
        int cp = 0x1f601;
        byte b[] = new String(Character.toChars(cp)).getBytes(StandardCharsets.UTF_8);
        for (int k=0; k<b.length; k++) 
              System.out.printf(" %x ", b[k]);
        System.out.println();
     }
}