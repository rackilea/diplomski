BufferedReader br = null;

    try {
        String line; 
        br = new BufferedReader(new FileReader("C:\\testing.txt"));
        while ((line= br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }