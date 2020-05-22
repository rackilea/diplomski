File file = new File("testwrite.txt");
            Scanner scanner = new Scanner(file);
            final int maxLines = 100;
            String[][] resultArray = new String[maxLines][];
            int linesCounter = 0;
            while (scanner.hasNextLine() && linesCounter < maxLines) {
                resultArray[linesCounter] = scanner.nextLine().split("-");
                linesCounter++;
            }