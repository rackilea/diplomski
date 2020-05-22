String message; // First message prompt
        String inputString; // For reading input.
        double numRows; // Number to be asked.
        double rowNumber = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the message you want to print? ");
        message = keyboard.nextLine();
        System.out.println("Enter how many times you want your message to beprinted.Enter the value from 1-20:");
        numRows = keyboard.nextDouble();

        double currentRow = numRows;
        while (currentRow > 0) {
            System.out.println("[WHILE] Row " + rowNumber + " - " + message);
            rowNumber++;
            currentRow--;
        }

        System.out.println("Times in while loop:" + rowNumber);
        System.out.println("Output using do-while loop...");
        currentRow = numRows;
        rowNumber = 1;

        do {
            System.out.println("[DO WHILE] Row " + rowNumber + " - " + message);
            currentRow--;
            rowNumber++;
        } while (currentRow > 0);

        System.out.println("Times in do-while loop..." + numRows);
        System.out.println("Output using for-loop:");
        currentRow = numRows;
        rowNumber = 1;

        for (double i = currentRow; currentRow > 0; currentRow--) {
            System.out.println("[FOR LOOP] Row " + rowNumber + " - " + message);
        }