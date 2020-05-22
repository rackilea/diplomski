public class PacketUtils {



public byte[] ItoBA4(int value) {       // integer to bytes function (return byte array of 4 bytes)
    return new byte[] {
            (byte)(value >>> 24),
            (byte)(value >>> 16),
            (byte)(value >>> 8),
            (byte)value};
}


public byte[] ItoBA2(int value) {   // integer to bytes function (return byte array of 2 bytes)
    return new byte[] {
            (byte)(value >>> 8),
            (byte)value};
}


public byte getDSN()    // return one byte random number
{
    char[] chars = "1234567890".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 1; i++) {
        char c = chars[random.nextInt(chars.length)];
        sb.append(c);
    }
    byte output = Byte.valueOf(sb.toString());
    return output;
}



public byte getCRC(byte[] packet)   //  required CRC function (return byte)
{
    try
    {
        if (packet == null)
        {
            //Logger.Error("empty packet received");
            return (byte)0;
        }

        byte XORCheckSum = 0;
        byte zeroCount = 0;
        byte FFCount = 0;

        for (int i = 0; i < packet.length; i++)
        {
            XORCheckSum ^= packet[i];
            if (packet[i] == (byte) 0)
            {
                zeroCount++;
                continue;
            }
            if (packet[i] == (byte)255)
            {
                FFCount++;
                continue;
            }
        }

        XORCheckSum ^= zeroCount;
        XORCheckSum ^= FFCount;
        return XORCheckSum;
    }
    catch (Exception ex)
    {
        //Logger.Error(ex);
        return (byte)0;
    }
}



byte[] concatBytes(byte[]...arrays)     //  concatenate byte arrays
{
    // Determine the length of the result array
    int totalLength = 0;
    for (int i = 0; i < arrays.length; i++)
    {
        totalLength += arrays[i].length;
    }

    // create the result array
    byte[] result = new byte[totalLength];

    // copy the source arrays into the result array
    int currentIndex = 0;
    for (int i = 0; i < arrays.length; i++)
    {
        System.arraycopy(arrays[i], 0, result, currentIndex, arrays[i].length);
        currentIndex += arrays[i].length;
    }

    return result;
}

public int getDateTime()
{
    int dateInSec = (int) (System.currentTimeMillis() / 1000);
    return dateInSec;

}



}