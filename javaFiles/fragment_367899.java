public class Weather
{
    private char[] cLow;
    private char[] cHigh;

    public Weather(int date) throws FileNotFoundException, IOException
    {
        // code here
        cLow = new char[(int)dateLow.length()];
        cHigh = new char[(int)dateHigh.length()];
        // code here
    }

    public static void main(String[] args)
    {
        Weather weather = new Weather(/*int value goes here*/);
        weather.lowest(/*char array variable goes here*/);
        weather.highest(/*char array variable goes here*/);
        // etc.
    }
}