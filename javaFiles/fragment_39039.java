while (input.hasNextLine()) {
        String readingInput = input.nextLine();
        Scanner readLine = new Scanner(readingInput);

        readLine.useDelimiter(",\\s+");
        String lastName = readLine.next();
        String firstName = readLine.next();
        String stdtID = readLine.next();

        String endOfString = readLine.next();
        if (!endOfString.trim().matches("\\d+.*")) {
            System.out.printf("%s, %s, %s, %s\n", lastName, firstName, stdtID, endOfString);
        } else {
            System.out.printf("%s, %s, %s\n", lastName, firstName, stdtID);
        }
    }