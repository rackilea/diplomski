public boolean readTreatmentsFromFile(String filename) {
    boolean result = false; // pessimistic default

        try {
            FileReader textFileReader = new FileReader(filename);
            BufferedReader textReader = new BufferedReader(textFileReader);

            System.out.println("READING TREATMENTS FROM FILE: " + filename);

            int week = Integer.parseInt(textReader.readLine());

            if (week != weekNumber) {
                throw new ArithmeticException(); 
            }

            String post = textReader.readLine();

            while(post != null) {
                addPost(post);
                post = textReader.readLine();
            }
            textReader.close();
            result = true;  // SUCCESS!
        }
        catch (ArithmeticException exception) {
            System.out.println("Invalid week number in the file: " + filename);
        }
        catch (FileNotFoundException exception) {
            System.out.print("The file cannot be located");
        }
        catch (IOException exception) {
            System.out.print("Cannot read the file:" + filename);
        }

        return result;
    }