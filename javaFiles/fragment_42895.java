public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        int amount;

        System.out.println("How many students do you have?");
        amount = keyboard.nextInt();
        while (amount < 0) {
            System.out.println("Invalid student amount");
            amount = keyboard.nextInt();
        }

        Student[] students = new Student[amount];
        for (int index = 0; index < amount; index++) {
            System.out.println("Enter score for student #" + (index + 1) + ": ");
            students[index] = new Student(index, keyboard.nextDouble());
        }

        Arrays.sort(students);

        for (int i = 0; i < amount / 10 + 1; i++) {
            System.out.println("Student " + (students[i].getIndex() + 1) + " has an A");
        }
    }