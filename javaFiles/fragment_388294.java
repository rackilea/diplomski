public static String [][] to2dim (String source, String outerdelim, String innerdelim) {

    String [][] result = new String [source.replaceAll ("[^" + outerdelim + "]", "").length () + 1][]; 
    int count = 0;
    for (String line : source.split ("[" + outerdelim + "]"))
    {
        result [count++] = line.split (innerdelim);
    }
    return result;
}

public static void show (String [][] arr)
{
    for (String [] ar : arr) {
        for (String a: ar) 
            System.out.print (" " + a);
        System.out.println ();
    }
}   

public static void main (String args[])
{
    show (to2dim ("a b c \n d e f \n g h i", "\n", " "));
}