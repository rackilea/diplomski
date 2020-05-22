public class StPrac1 {

    public static void main(String[] args) {

        String name;

        System.out.println("Please your full name");

        Scanner kbd = new Scanner( System.in );
        name = kbd.nextLine();
        string fname = name.Split(" ")[0];
        string sname = name.Split(" ")[1];
        string output = sname + ", " + fname;

        System.out.print(output);


    }
    }