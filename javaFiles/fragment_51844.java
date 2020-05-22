Scanner scanner = new Scanner(new File("resources/abc.txt"));
    //check for next line
    while (scanner.hasNextLine()) {
        //create new scanner for each line to read string and integers
        Scanner scanner1 = new Scanner(scanner.nextLine());
        //read name
        String name = scanner1.next();
        double total = 0;
        int count = 0;
        //read all the integers
        while (scanner1.hasNextInt()) {
            total += scanner1.nextInt();
            count++;
        }
        System.out.println(name + ", average = " + (total / count));
    }
    scanner.close();