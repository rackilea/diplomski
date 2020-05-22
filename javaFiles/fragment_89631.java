public class Test {
    public static void main(String args[]) throws Exception {
        // bytes in the first argument, encoded using second argument
        byte[] bs = args[0].getBytes(args[1]);
        System.err.println(bs.length + " bytes:");

        // print hex values of bytes and (if printable), the char itself
        char[] hex = "0123456789ABCDEF".toCharArray();
        for (int i=0; i<bs.length; i++) {
            int b = (bs[i] < 0) ? bs[i] + 256 : bs[i];
            System.err.print(hex[b>>4] + "" + hex[b&0xf] 
                + ( ! Character.isISOControl((char)b) ? ""+(char)b : ".")
                + ( (i%4 == 3) ? "\n" : " "));
        }
        System.err.println();   
    }
}