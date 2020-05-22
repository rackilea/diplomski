Path originalPath = Paths.get("file1.txt");
    //Read the file content and add each line in list
    List<String> orginalContentLines = Files.readAllLines(originalPath);

    //Combine all lines to one string
    String originalContent = orginalContentLines.stream().collect(Collectors.joining("\r\n"));

    //Format the content by replacing * with new line
    String newContent = originalContent.replaceAll("\\*+", "\r\n");

    //Create the new file 
    Path newPath = Paths.get("file2.txt");
    Files.createFile(newPath);

    //Write to new file
    Files.write(newPath, newContent.getBytes());