// Java
public class Test
{
    public static void main(String[] args)
    {
        double input = 0.392156862745098;
        double pow = Math.pow(input, 1.0/3.0);            
        System.out.println(Double.doubleToLongBits(pow));
    }
}

// C#
using System;

public class Test
{
    static void Main()
    {
        double input = 0.392156862745098;
        double pow = Math.Pow(input, 1.0/3.0);            
        Console.WriteLine(BitConverter.DoubleToInt64Bits(pow));
    }
}