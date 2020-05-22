try {
    int number = 500;
    int result = number / 0;
    //This will throw an exception for dividing by zero.

    int[] array = new int[10];
    int bad = array[11];
    //This will throw an ArrayIndexOutOfBoundsException

}
catch(Exception e)
{
    System.out.println("I caught one! Here's some info: ")
    e.printStackTrace();
}