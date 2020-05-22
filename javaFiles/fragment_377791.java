import org.apache.commons.codec.binary.Hex;

public class StringToAscii
{
    public static void main( String[] args ) 
    {
        try {
            String s = "汉1232";
            System.out.println(s);
            String hexString = new String(Hex.encodeHexString(s.getBytes("UTF-8")));
            System.out.println(hexString);
            String unicode = new String(Hex.decodeHex(hexString.toCharArray()));
            System.out.println(unicode);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}