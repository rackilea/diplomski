public boolean load(String filename)
{
    try
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("wordlist.txt")));
        String line = null;

        // I'm leaving this loop under the assumption that there may be multiple lines
        while ((line = br.readLine()) != null) 
        {
            String[] values = line.split(",");
            for (int i = 0; i < line.lenght() / 2; ++i) {
                wordlist.add(new WordPair(values[i], values[i + 1));
            }
        }
    } catch (IOException ioe)
    {
        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ioe);
    }

    return false;
}