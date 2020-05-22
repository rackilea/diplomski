private static int getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a number");
        String num1 = scanner.nextLine();
        System.out.println("Please input a second number");
        String num2 = scanner.nextLine();
        if(num1.matches("[0-9]+") && num2.matches("[0-9]+")) {
            return Integer.parseInt(num1)+ Integer.parseInt(num2);
        } else {
            System.out.println(" Your inputs contain Invalid characters");
            getAnswer();
        }
       return 0;
    }