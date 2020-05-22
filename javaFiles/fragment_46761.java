int lineNumber = 1;

    while (fileInput.hasNextLine()) {
        String line = fileInput.nextLine();
        String[] data = line.split(" ");
        try {
            sum+= Double.valueOf(data[0]);
        } catch (Exception ex) {
            output2.println("Error at line "+lineNumber+ " - "+line);
        }
        lineNumber++;
    }
    output.println("Total: "+sum);