private void readFile(BufferedReader file) throws IOException {
    int expectedCount = -1;
    try {
            int count;
            count = 0;

            while ((count = file.read()) != -1 && (expectedCount > 0 || expectedCount == -1 ) ) {
                if ( expectedCount == -1 ) {
                    // read count and set in expectedCount
                } else {
                    //do what you need to do with the input
                    System.out.print((char) count);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            file.close();
        }
    }