...
        reader = new Scanner(file);
        int counter = 1;
        while (reader.hasNextLine()) {
            final String line = reader.nextLine();
            if (line.isEmpty()) {
                System.out.println("This is an empty line");
            } else {
                System.out.printf("%2d.", counter++); // Use printf to format
                System.out.println(line);
            }
        }
        reader.close();
...