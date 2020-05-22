private static void saveState(String state, String fileName) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            writer.println(state);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    private static String readState(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            return reader.readLine();
        } finally {
            if (reader != null)
                reader.close();
        }
    }