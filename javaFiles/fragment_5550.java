public class Drivers_License
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int incorrect = 0;
        double grade = 0.0;
        String input;
        char[] answerKey = {'B', 'D', 'A', 'A', 'C',
                            'A', 'B', 'A', 'C', 'D',
                            'B', 'C', 'D', 'A', 'D',
                            'C', 'C', 'B', 'D', 'A'};
        System.out.println();

        int total = 0;
        char[] responses = new char[20];
        for (int i = 0; i < responses.length; i++) 
        {
            System.out.printf("Enter answer for # %d: ", i+1);
            responses[i] = scan.nextLine().toUpperCase().trim().charAt(0);

        }

        int numCorrect = 0;
        for (int i = 0; i < responses.length; i++) {
           if (responses[i] == (answerKey[i])) { // Look here
                System.out.println(responses[i]);
                numCorrect++;
            }
        }

        /* Display elements in userAnswers array */
        System.out.println("User answers are below");
        for (int i = 0; i < responses.length; i++) {
            System.out.print(responses[i] + " ");
        }
        System.out.println();
    }