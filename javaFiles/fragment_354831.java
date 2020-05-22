while (circleAngle <= 0 || circleAngle >= 360)
{
    System.out.print("You have an invalid entry.");
    System.out.print("Please input an angle greater than 0 and less than 360:");
    circleAngle = userInput.nextFloat();
}