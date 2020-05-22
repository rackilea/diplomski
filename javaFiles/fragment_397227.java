private static void executeFile(Connection c, String fileName)
       throws SQLException, IOException {
    try (InputStream is = new FileInputStream(fileName);
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader reader = new BufferedReader(isr)) {
        /* Lots of stuff */
    }
}