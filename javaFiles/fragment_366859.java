import java.util.Arrays;

public class test
{
    private static final int BYTES = 4;

    public static void main(String[] args){
        int v = 12345678;

        int at_arr = BYTES - 1;
        byte[] result = new byte[BYTES];//int is 32-bit/4 byte long

        for(int lowerBound = 1 ; lowerBound < Integer.MAX_VALUE && at_arr > -1; lowerBound *= 100, at_arr--)
            result[at_arr] = transformDigits((v / lowerBound) % 100);

        for(byte b : result)
            System.out.print(" 0x" + Integer.toString(b , 16) + ",");
        System.out.println();
    }

    static byte transformDigits(int i){
        if(i == 0)
            return 0x00;

        int lsd = (i % 10); //least significant digit of the input (decimal)
        int msd = (i / 10); //most significant digit

        //merge lsd and msd into a single number, where the lower 4 bits are reserved for
        //lsd and the higher 4 bits for msd
        return (byte) (lsd | (msd << 4));
    }
}