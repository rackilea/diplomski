public class Test
{
    // Pattern  1    2    2    3    1    1    2
    // Bin      01   10...10   11...01   01...10
    // Bin      01   1010      1101      0110
    // Hex      1    A         D         6
    // Hex      1AD6    

    static int pattern = 0x1AD6;

    public static int getNumber(int i)
    {
        return (pattern >> i) & 0x03;    
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 14; i += 2)
        {
            System.out.println("***".substring(0, getNumber(i)));
        }
    }
}