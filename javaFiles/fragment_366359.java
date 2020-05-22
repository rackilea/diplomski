import java.util.Random;
/* Name of the class has to be "Main" only if the class is public. */
class NickName_1
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int letterNum = 6;
        Random rn = new Random();
        char letter = (char) (rn.nextInt(26) + 'a');
        boolean shouldCons = true;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

        while (true)
        {
            //Ask user for word's length and store it
            System.out.println();
            System.out.print("Please enter the length of the word in letters: ");
            try{
                letterNum = scanner.nextInt();
            }catch(Exception e){
                break;
            }

            for (int i = 0; i < letterNum; i++, shouldCons^=true)
            {
                if(shouldCons) {
                    letter = (char) (rn.nextInt(26) + 'a');
                    while (letter == 'a' || letter == 'u' || letter == 'i' || letter == 'e' || letter == 'o')
                    {
                        letter = (char) (rn.nextInt(26) + 'a');
                    }
                }
                else letter = vowels[(int)(Math.random() * 5)];

                System.out.print(letter);
            }
        }
    }
}