Scanner stdin = new Scanner(System.in);

        System.out.print("Enter your average: ");
        String name = stdin.next();

        int count = 0;
        int sum = 0;
        Scanner scores = new Scanner(stdin.nextLine());
        while (scores.hasNextInt()) {
            sum += scores.nextInt();
            count++;
        }
        double avg = 1D * sum / count;
        System.out.print(name + "  " + avg);