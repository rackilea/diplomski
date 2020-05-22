int scores = 0; //This will hold the sum of the scores
    for (i = 1; i <= x; i++)
    {
        System.out.print("Enter score " + i + ": "); //Ask for new score
        scores = scores + Integer.parseInt(input.readLine()); //Add score to existing sum of previous scores
    }
    System.out.println("The average score is " + scores / x); // Gets the average score and prints to console