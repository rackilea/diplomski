List<String> textFileNames = new ArrayList<String>();
    File directory= new File("StackTxtFiles"); // Point to your directory you want to search
    for (File file : directory.listFiles()) // Loop over everything that exists in the directory
    {
       if (file.getName().endsWith(".txt")) // if the extension is ".txt", it's a text file so we should include it
       {
           textFileNames.add(file.getName()); // Add the file's name to the included list
       }
    }