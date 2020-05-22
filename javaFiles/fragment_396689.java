public static void main(String args[]) throws Exception {
    FileInputStream file = null;
    BufferedReader br = null;
    try {
        file = new FileInputStream(
                "C:/Users/Shashu/Desktop/Workspace/sample.txt");
        br = new BufferedReader(new InputStreamReader(file));

        int countw = 0, countl = 0, countc = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
            countl++;
            String[] words = line.split(" ");
            for (String word : words) {
                word = word.trim();
                if (word.length() == 0) {
                    continue;
                }
                countw++;
                countc += word.length();
            }

        }
        System.out.println("Number of words " + countw);
        System.out.println("Number of lines " + countl);
        System.out.println("Number of characters " + countc);
    } finally {
        if (file != null) {
            file.close();
        }
    }

}