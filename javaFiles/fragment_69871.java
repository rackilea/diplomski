// Directory path here
    String path = ".";

    String files;
    File folder = new File(path);
    // Returns an array of the files in the directory denoted.
    File[] listOfFiles = folder.listFiles();


    for (int i = 0; i < listOfFiles.length; i++) {

        if (listOfFiles[i].isFile()) {

            //Checks if the type of the file is a text file.
            files = listOfFiles[i].getName();
            if (files.endsWith(".txt") || files.endsWith(".TXT")) {

                // Reads the file and show every line on the screen.
                File file = listOfFiles[i];
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            file.getAbsolutePath()));

                    String line = null;
                    while ((line = reader.readLine()) != null) {

                        System.out.println(line);

                    }
                } catch (IOException e) {

                }
            }
        }
    }