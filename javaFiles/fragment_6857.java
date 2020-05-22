public static String read(File file) throws FileNotFoundException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
                if (line != null) sb.append(System.lineSeparator());

            }
            String everything = sb.toString();
            return everything;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }