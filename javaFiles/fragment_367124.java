EasyReader console = new EasyReader(); //Connect to EasyReader.class
System.out.print("Enter the score from game 1: ");
double score1 = console.readDouble(); //Reads the user input for game 1 
System.out.print("Enter the score from game 2: ");
double score2 = console.readDouble(); //Reads the user input for game 2
System.out.print("Enter the score from game 3: ");
double score3 = console.readDouble(); //Reads the user input for game 3
double averageScore = average(score1, score2, score3);
displayScores(score1, score2, score3, averageScore);