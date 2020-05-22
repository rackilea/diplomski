public static HashMap<String,Integer> readVocabulary(String toRead)
{ 
    // Declare the HashMap to be returned 
    HashMap<String, Integer> wordCount = new HashMap<String, Integer>(); 

    String line = null;
    String[] words = null;
    int lineNumber = 0;
    FileReader reader = null;
    BufferedReader br = null;

    try { 
        reader = new FileReader(toRead); 
        br = new BufferedReader(reader); 

        // Split the line into a String array to loop through 
        while ((line = br.readLine()) != null) {
            lineNumber++;
            words = line.split(" "); 
            if (words.length == 2) {

                if (wordCount.containsKey(words[0]))
                { 
                    int n = wordCount.get(words[0]); 
                    wordCount.put(words[0], ++n); 
                } 
                // Otherwise, puts the word into the HashMap 
                else
                {  
                    boolean word2IsInteger = true;
                    try  
                    {  
                        Integer.parseInt(words[1]);
                    } 
                    catch(NumberFormatException nfe)  
                    {  
                        word2IsInteger = false;  
                    }
                    if (word2IsInteger) {
                        wordCount.put(words[0], Integer.parseInt(words[1])); 
                    }
                } 
            }
        } 
        br.close();
        br = null;
        reader.close();
        reader = null;
    } 
    // Catching the file not found error 
    // and any other errors 
    catch (FileNotFoundException fnfe) { 
        System.err.println("File not found."); 
    } 
    catch (Exception e) { 
        System.err.print(e); 
    } 

    return wordCount; 
}