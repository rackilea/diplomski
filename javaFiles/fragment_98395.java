public class Order {

    PrintWriter outputfile;
    FileWriter writer;

    public void validate(Scanner input) { 

        String userEntry;       

        System.out.println("Please enter a positive integer greater than 0.");
        userEntry = input.nextLine();

        while (!userEntry.matches("^[1-9][0-9]*$")) {
            System.out.println("Invalid number. Try again");
            userEntry = input.nextLine();
        }

        try {
            writer = new FileWriter("outDataFile.txt", true);
            outputfile = new PrintWriter(writer);

            outputfile.println("Your original number was: ");
            outputfile.println(userEntry);
            outputfile.flush();
            System.out.println("Your original number was: ");
            System.out.println(userEntry);

            System.out.println("The reversed digits are: ");
            outputfile.println("The reversed digits are: ");
            reverse (input, userEntry, writer);
            System.out.println();

        } catch (IOException e){            
        }            
    }

    //Reverses the order of digits.
    public void reverse(Scanner keyboard, String intString, FileWriter writer) {

        outputfile = new PrintWriter(writer);

        int strsize = intString.length();
        int[] digits = new int[strsize];

        for (int i = 0; i < strsize; ++i)
        {
            String temp = Character.toString(intString.charAt(i));
            digits[i] = Integer.parseInt(temp);
        }

        for (int i = strsize - 1; i >= 0; --i)
        {         
            System.out.print(digits[i]);
            outputfile.print(digits[i]);
            outputfile.flush();
        }
    }   
}