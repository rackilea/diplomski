public static void main(String[] args) {
    while(true) {
        Scanner input = new Scanner(System.in);

        userinput:

        System.out.println("Enter you name:");

        String name = input.nextLine();

        System.out.println("OK! Now enter your age:");

        int age;

        age = input.nextInt();

        System.out.println("Good! And the city you live in, please:");

        Scanner in = new Scanner(System.in);

        String city = in.nextLine();

        System.out.println("So, let's check");
        System.out.println("Your name is " + name + ". You are " + age + " years old and you currently live in " + city + ".");
        System.out.println("Is that right?");

        Scanner inp = new Scanner(System.in);

        String yesno = inp.nextLine();

        if (yesno.equals("yes") || yesno.equals("Yes") || yesno.equals("YES")) {
            System.out.println("Great job!");
            break;
        }

        else {
            System.out.println("Let's try again then!");
        }
    }
}