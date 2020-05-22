Scanner input = new Scanner(System.in);

    String answer = "a";
    String question = " ";
    int currentResponse = 0;

    System.out.println("How many responses would you like there to be?");
    int numResponses = input.nextInt();
    input.nextLine();
    String[] responses = new String[numResponses];

    //This is the loop that's the problem:

    for (int i = 0; i < numResponses; i++)
    {
        System.out.println("Enter an answer: ");
        answer = input.nextLine();
        responses[i] = answer; //Should set the array value to the input
    }

    //This is where I tried two different ways of printing out the array to
    //test it just in case that was the problem:

    System.out.println(Arrays.toString(responses));

    for (int i = 0; i < responses.length; i++)
    {
        System.out.print(responses[i] + " ");
    }

    while (!question.equalsIgnoreCase("stop"))
    {
        System.out.println("What is your question?");
        question = input.nextLine();
        currentResponse = (int)(Math.random() * numResponses);
        System.out.println(currentResponse);
        System.out.println(responses[currentResponse]); //It also doesn't appear to
    //actually print this out but I think that that's because the values are //blank spaces
    }

    System.out.println("Thank you for using the Magic Eight Ball");
}