public static int getInteger()
{
    int input = 0;
    Scanner user_input = new Scanner( System.in );
    System.out.print("Enter a integer: ");

    while (!user_input.hasNextInt() && !user_input.hasNextDouble()) {
        System.out.println("Is not a valid number.");

        user_input.next();
    }

    if(user_input.hasNextInt()) {
        input = user_input.nextInt();
    }
    else {
        input = Math.round((float) user_input.nextDouble()); //I assume here that your number is small as you said
    }

    return input;
}