boolean badAnswer = true;
int gear = 0;

while(badAnswer)
{
    System.out.println("Enter the gear :");
    gear = input.nextInt();

    if(gear > 0 && gear <= 3)
    {
        bike.setGear(gear);
        badAnswer = false;
    }
    else
    {
        System.out.println("Please enter a value for gear between 1 and 3.");

    }
}