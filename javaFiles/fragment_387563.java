Scanner input = new Scanner(System.in);

    System.out.println("What is the filename?");
    String filename1 = input.nextLine();
    try (BufferedWriter finalFile = new BufferedWriter(new FileWriter(filename1))) {
        boolean done = false;
        do {
            System.out.println("Enter a number");
            String value = input.nextLine();
            done = value.equalsIgnoreCase("done");
            if (!done) {
                try {
                    double number = Double.parseDouble(value);
                    finalFile.write(Double.toString(number));
                    finalFile.newLine();
                } catch (NumberFormatException fnfe) {
                    System.out.println("Not valid");
                }

            }
        } while (!done);
    } catch (IOException ex) {
        ex.printStackTrace();
    }