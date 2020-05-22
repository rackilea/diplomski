public static void age() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = console.nextInt();

        if (age >= 18) {
            System.out.println("Legit to vote");
        } else {
            System.out.println("Not Legit to vote");
        }

    }