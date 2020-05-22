public static void main(String[] args) {
        try {
            Scanner bufferedScanner = new Scanner(new BufferedReader(new FileReader ("Sample.txt")));
            while (bufferedScanner.hasNextLine()) {
                String currentLine = bufferedScanner.nextLine();
                Scanner lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");

                int first = lineScanner.nextInt();
                int second = lineScanner.nextInt();
                // Here is where I read a string than an int value
                // on the 2nd line of the input file
                int third = lineScanner.nextInt();
                int forth = lineScanner.nextInt();


                System.out.println(first + ", " + second + ", " + third + ", " + forth);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }