public static void getProperties(String infile) throws IOException {
        final int lhs = 0;
        final int rhs = 1;

        ArrayList list = new ArrayList();
        BufferedReader  bfr = new BufferedReader(new FileReader(new File(infile)));

        String line;
        while ((line = bfr.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] pair = line.trim().split(":");
                list.add(pair[rhs].trim());
            }
        }

        bfr.close();

        System.out.println(list.toString());
    }