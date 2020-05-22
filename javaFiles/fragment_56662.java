import java.util.Scanner;

class Reverse {
    public static void main(String args[])
    {
        String original;
        String reverse = "";

        Scanner kbd = new Scanner(System.in);


        StringBuilder output = new StringBuilder();

        while (kbd.hasNextLine()) 
        {
            original = kbd.nextLine();
            StringBuilder sb = new StringBuilder(original);
            output.append(sb.reverse().toString()).append("\n");
        }
        System.out.println(output.toString());
    }
}