public class PixelBytes
{
    public static void main(String[] args)
    {
        byte r = (byte)(100);
        byte g = (byte)(240);
        byte b = (byte)0;
        compute(r, g, b);
    }

    private static byte compute(byte r, byte g, byte b)
    {
        byte sr = (byte) (r * 0.299);
        byte sg = (byte) (g * 0.587);
        byte sb = (byte) (b * 0.114);
        byte s = (byte) (sr + sg + sb);

        byte tr = (byte) (toUnsignedInt(r) * 0.299);
        byte tg = (byte) (toUnsignedInt(g) * 0.587);
        byte tb = (byte) (toUnsignedInt(b) * 0.114);
        byte t = (byte) (tr + tg + tb);

        System.out.println("For " + r + " " + g + " " + b);
        System.out.println("add " + sr + " " + sg + " " + sb + " to get " + s);
        System.out.println("or  " + tr + " " + tg + " " + tb + " tp get " + t);

        return s;
    }

    // Same as Byte#toUnsignedInt in Java 8
    private static int toUnsignedInt(byte b)
    {
        return ((int) b) & 0xff;        
    }
}