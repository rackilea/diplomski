public class CUSTOM {
    public static void main(String[] args) {
        double[] arr = new double[]{1.1,1.3};
        byte[] barr = toByteArray(arr);
        for(byte b: barr){
            System.out.println(b);
        }
    }
    public static byte[] toByteArray(double[] from) {
        byte[] output = new byte[from.length*Double.SIZE/8]; //this is reprezented in bits
        int step = Double.SIZE/8;
        int index = 0;
        for(double d : from){
            for(int i=0 ; i<step ; i++){
                long bits = Double.doubleToLongBits(d); // first transform to a primitive that allows bit shifting
                byte b = (byte)((bits>>>(i*8)) & 0xFF); // bit shift and keep adding
                int currentIndex = i+(index*8);
                output[currentIndex] = b;
            }
            index++;
        }
        return output;
    }
}