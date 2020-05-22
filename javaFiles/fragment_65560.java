Scanner input = new Scanner(System.in);

do {
    randomNumber = (int) (Math.random() * jokes.length);
    System.out.println("Bot: " + jokes[randomNumber] + " Type reveal to view answer");

    System.out.print("You: ");
    userInput = input.nextLine();
    userInput = userInput.toLowerCase();

    while (!userInput.equals("reveal"))
    {
        System.out.println("Bot: Wrong! >:D");

        System.out.print("You: ");
        userInput = input.nextLine();
        userInput = userInput.toLowerCase();
    }

    System.out.println("Bot: " + jokesAnswer[randomNumber] + "\nBot: Do you want to hear another joke? :D Yes or No?");

    System.out.print("You: ");
    userInput = input.nextLine();
    userInput = userInput.toLowerCase();

} while (!userInput.equals("no"));