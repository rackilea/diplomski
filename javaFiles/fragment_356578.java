public static void main(String[] args) 
    {
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\words.txt")))
        {
            String currentWord;
            while ((currentWord = br.readLine()) != null)
            {
               //USE EACH OF YOUR STRINGS HERE i.e String dogName = currentWord
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }