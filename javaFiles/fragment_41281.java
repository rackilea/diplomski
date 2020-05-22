public class DecToHex
{
    static int BASE = 0xFF;
    static int SHIFT = 8;

    public static void main(String[] args)
    {
        byte[] ascii = new byte[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        byte[] result = convertAsciiAmount(ascii, (byte)8);
        printAsHex(result);
    }

    static byte[] convertAsciiAmount(byte[] ascii, byte capacity)
    {
        byte len = 0;
        byte[] result = new byte[capacity];

        result[0] = (byte)(ascii[0]-'0');
        for(byte i=1; i<ascii.length; i++)
        {
            byte digit = (byte)(ascii[i]-'0');

            // multiply result by 10
            len += 1;           
            short prod = 0;
            for(byte j=0; j<len; j++)
            {
                prod += (10 * (result[j]  & BASE));
                result[j] = (byte)prod;
                prod >>>= SHIFT;
            }
            result[len] = (byte)prod;           
            while(len > 0 && result[len-1] == 0) len--;

            // add current digit            
            short sum = 0;
            sum += (result[0] & BASE) + (digit & BASE);
            result[0] = (byte)sum;
            sum >>>= SHIFT;

            for(byte j=1; j<len; j++)
            {
                sum += (result[j] & BASE);
                result[j] = (byte)sum;
                sum >>>= SHIFT;
            }

            if(sum > 0)
            {
                result[len++] = (byte)sum;
            }
        }       
        return result;
    }

    static void printAsHex(byte[] hex)
    {
        for(byte i=(byte)(hex.length-1); i>=0; i--)
        {
            System.out.print(String.format("0x%02X", (hex[i] & BASE)) + " ");
        }
        System.out.println();       
    }
}