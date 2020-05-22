while (poem.hasNext()) 
{ 
    String s = poem.nextLine();
    System.out.println(s); // <<< Display each line as you process it
    String[] words = s.split(" "); 
    countWords += words.length; 
    for (int i = 0; i < words.length; i++) 
    { 
        countsOf3 += words[i].length() == 3 ? 1 : 0; // checks for 3-letter words
    } 
}