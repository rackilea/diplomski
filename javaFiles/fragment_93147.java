public class Javafool 

     {

static String [] myArray = {"Khaled","Valderama","Daoud","Khaled","Rasheed","Daoud","Valderama","Khalo","Valderama","Daoud"};

static String str2[] = new String[myArray.length];

     public static void main(String[] args)

     {

     int [] noOftimesRepeated;

      sort(myArray);

      int no_of_repeat=1;

      String temp =null;

       int i   ;

       int count = 0;

       String previous = null;

      for (String s : myArray) 

      {

     if (s.equals(previous))

     {

     count++;
     } 

     else 

     {

     if( previous !=null)

     System.out.println(previous + " :" + count);

     previous = s;

     count = 1;

     }

     }

     if (myArray.length > 0)

    {

    System.out.println(previous + " :" + count);

    }

    }

   public static void sort(String [] array) {

   String temp = null;

   for(int j=0;j<array.length;j++)

  {

 for(int i = 0; i<array.length-1;i++)

  {

  if(array[i].compareTo(array[i+1])<0)

  {

  temp = array[i];

  array[i] = array[i+1];

  array[i+1] = temp;

 }

 }

    } } }