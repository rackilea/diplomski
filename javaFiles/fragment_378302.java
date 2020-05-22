public class Assignment1 {
    public static void main(String args[]) {
        if (args.length == 2) {
            int c = Integer.parseInt(args[1]);
            if (c > args[0].length()) {
                System.out.println("the index " + args[1] + " is out of range !");
            } else {
                System.out.println("The character is " + args[0].charAt(c - 1) + " !");
            }
        }
        else {
            System.out.println("Usage: java Assignment1 <argument1> <argument2>\n E-g java Assignment1 abcd 4");
        }
    }
}