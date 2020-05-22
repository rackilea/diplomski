public static void readFile(String bookID, UserInterface userInterface) {
        try {

            FileReader read = new FileReader("inventory.txt");
            BufferedReader buffer = new BufferedReader(read);
            StringBuffer stringBuff = new StringBuffer();
            String line, delim = "[,]";
            for (int i = 0; i < 12; i++) {
                line = buffer.readLine();
                String[] tokens = line.split(delim);

                if ((Objects.equals(tokens[0], bookID)) == true) {
                    userInterface.setInfo(tokens[1]);
                }
            }

        } catch (IOException e) {
            System.out.println("Error starting file!");
        }
    }