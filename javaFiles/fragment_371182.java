public static void main(String args[])
{
    try
    {
        ...
        // assuming your string is "2,5,6,10,5,30"
        String[] tokens = strLine.split(",");
        // tokens will be [2,5,6,10,5,30], size = 6
        Random r = new Random();
        for (int a = 1 ; a < 3 ; a++) //a++ is a short way of writing a = a + 1
        {
            int randomInt = r.nextInt(tokens.length); // an integer between 0 and 5
            System.out.println(tokens[randomInt]);
        }
    }
    ...
}