public static void main (String[] args) throws java.lang.Exception
{
    int Num, counter, i;
    String str1;
    int NumTot = 0;

    str1 = "3124";
    Num = str1.length();

    counter = 0;
    while (counter < Num)
    {


        i = Integer.parseInt(Character.toString(str1.charAt(counter)));
        NumTot = NumTot + i;
        counter++;
    }



  System.out.println(NumTot);
}