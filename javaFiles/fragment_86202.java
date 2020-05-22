public static void bubbleSort(Student[] array)
{
    for(int i=(array.length); i>0; i--)
    {

        for(int j=1; j<(array.length-i); j++) 
        {
             if( array[j].getName().compareTo(array[j+1].getName())<0)

            {
                Student Temp = array[j];
                array[j] = array[j+1];
                array[j+1] = Temp;
            }

        }
    }

    String s = ""; // should not be null

    for (int i = 0; i < array.length; i++)
    {
        s = s + array[i].getName()+" "+ array[i].getId(); // changed this line
        System.out.print (s); // moved this into the loop because I think this makes more sense
    }
}