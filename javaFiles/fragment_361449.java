public static void main(String args[])
{
    Random ran = new Random();

    //Generate a digit between 0-8 +1
    int number = ran.nextInt(9) + 1;
    //Multiply with 10000
    number *= 10000;
    //Add a number between 0-9999
    number += ran.nextInt(10000);

    System.out.println("Random no:" + number);
}