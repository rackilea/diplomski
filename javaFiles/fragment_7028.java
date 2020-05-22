Scanner scanner = new Scanner(new File("input.txt"));
    PrintWriter writer = new PrintWriter("output.txt");

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();     // read a line from the input file
        writer.println(line.split(" ")[1]);   // write a line to the output file
    }

    scanner.close();
    writer.close();