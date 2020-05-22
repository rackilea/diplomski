int week = 1;
        while (inputFile.hasNext()) {
            // Read a value from the file.
            budget = inputFile.nextFloat();

            System.out.print("\nBudget for week " + week++ + ":");
            System.out.println(String.format("%" + (budget / 100) + "s", "").replaceAll(" ", "*"));

        }