public static void copyCharacters() throws IOException {
            FileWriter outputStream = null;
            BufferedReader bufferedReader = null;

            Deque<String> fileContents = new ArrayDeque<>();

            try {
                outputStream = new FileWriter("motown_output.txt");
                bufferedReader = new BufferedReader(new FileReader("motown.txt"));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileContents.add(line);
                }

                for (Iterator<String> iterator = fileContents.descendingIterator(); iterator.hasNext();) {
                    outputStream.write(iterator.next());
                    outputStream.write("\n");
                }

            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
         }