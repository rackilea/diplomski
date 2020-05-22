List<String> lines = new ArrayList<String>();
    for(String fileName : textFileNames){ // Loop over each file that we found in the directory searching
        BufferedReader fileReader = new BufferedReader(new FileReader("StackTxtFiles/"+fileName)); // Create reader with access to file. Add the directory we are looking in
        String fileLine = fileReader.readLine(); // Read the first line
        while (fileLine != null) { // While there are still lines to read, keep reading
            lines.add(fileLine); // Store the current line
            fileLine = fileReader.readLine(); // Grab the next line
        }
        fileReader.close(); // Read all the lines, so close the read
    }