Scanner inFile = new Scanner(new File
                          ("C:/COSC        210/Assignment#7/parts.txt" ));
    inFile.useDelimiter(",");
    while (inFile.hasNext()) {
        int partNumber = Integer.parseInt(inFile.next());
        String description = inFile.next();
        double price = Double.parseDouble(inFile.next());
        String city = inFile.next();
        int quantity = Integer.parseInt(inFile.nextLine().replaceAll(",", ""));
        if(inFile.hasNextLine()) inFile.nextLine();
        System.out.println(partNumber+","
                +description+","
                +price+","
                +city+","
                +quantity);
    }
    inFile.close();