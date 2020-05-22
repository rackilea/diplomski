int numberOfProcesses = 0;
    boolean success = true;
    do {
        try {
            System.out.print("Processes: ");
            String s = input.nextLine();
            numberOfProcesses = Integer.parseInt(s);
            success = true;
        } catch (NumberFormatException e) {
            success = false;
            System.out.println("Wrong Input. Please put integer number.");
        }
    } while (!success);