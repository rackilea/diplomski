public class StreamFilter {

     public static void main(String[] args) {
         System.out.print("Enter Your Name: ");
         Scanner inputName = new Scanner(System.in);
         String score="hui";
         String name = inputName.nextLine();

            try {
                File highscore = new File("highscore.txt");

                PrintWriter output = new PrintWriter(highscore);//remove this
PrintWriter output = new PrintWriter(new FileWriter(highscore, true));//usethis,
                if (highscore.exists()) {
                    System.out.println("Score has been saved!");
                }           
                output.println(name + " - " + score);
                output.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }