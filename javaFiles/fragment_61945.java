public class Test
{

    public static void main(String[] args)
    {
        Test t = new Test();
        t.Test();
    }

    public void Test()
    {
        String input = "Hèllo world";
        byte[] inputBytes = GetBytes(input);
        String output = GetString(inputBytes);
        System.out.println(output);
    }

    public byte[] GetBytes(String str)
    {
        char[] chars = str.toCharArray();
        byte[] bytes = new byte[chars.length * 2];
        for (int i = 0; i < chars.length; i++)
        {
            bytes[i * 2] = (byte) (chars[i] >> 8);
            bytes[i * 2 + 1] = (byte) chars[i];
        }

        return bytes;
    }

    public String GetString(byte[] bytes)
    {
        char[] chars = new char[bytes.length / 2];
        char[] chars2 = new char[bytes.length / 2];
        for (int i = 0; i < chars2.length; i++)
            chars2[i] = (char) ((bytes[i * 2] << 8) + (bytes[i * 2 + 1] & 0xFF));

        return new String(chars2);

    }
}