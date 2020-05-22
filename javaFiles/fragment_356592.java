while(!(user_command.equals("exit")) {
    System.out.print("Would you like toppings?(yes/no):");
    user_command = user_input.next();
    if(user_command.toLowerCase().equals("yes"))
    {
        System.out.println("Good Eat Your Pizza.");
    }
    else if (user_command.toLowerCase().equals("no"))
    {
        System.out.println("Well Ok Then!");
    }
    else
    {
        System.out.println(apology);
        System.exit(1);
    }
}