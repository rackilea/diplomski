BufferedWriter out = null;
    try {

        // Read File Contents - score
        BufferedReader br = new BufferedReader(new FileReader("c:\\a.txt"));
        String storedScore="0";
        int storedScoreNumber = 0;
        while ((storedScore = br.readLine()) != null) {
            storedScoreNumber=(Integer.parseInt(storedScore==null?"0":storedScore));
        }

        // Write File Contents - incremented socre
        out = new BufferedWriter(new FileWriter("c:\\a.txt", false));
        out.write(String.valueOf(storedScoreNumber+1));

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }