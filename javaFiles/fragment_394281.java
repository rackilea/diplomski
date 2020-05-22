List<String> previousWords = new ArrayList<String>();
List<String> nextWords = new ArrayList<String>();
boolean foundKeyWord = false;

Scanner sc2 = null;
try {
    sc2 = new Scanner(new File("translate.txt"));
} catch (FileNotFoundException e) {
    e.printStackTrace();  
}
while (sc2.hasNextLine()) {
        Scanner s2 = new Scanner(sc2.nextLine());
    boolean b;
    while (b = s2.hasNext()) {
        String s = s2.next();
        if(!foundKeyWord) {
           if(s.equals(findKeyWord)) {
             foundKeyWord = true;
           }
        }
       //Keyword not found then add to the previouswords list
        if(!foundKeyWord) {
           previousWords.add(s);
        } else {
          //already key found now we need to add next 50 words
           if(nextWords.size <= 50) {
               nextWords.add(s);
           } else {
             //if 50 key words are added then break from the loop, if in case if there are less than 50 words in file after keyword then scanner will end.
             break;
           }

        }

    }
}

//Now we need to fix the previous 50 key words in case if keyword is found after 50th word.

  if(previousWords.size > 50){
     previousWords.subList(previousWords.size() - 50, previousWords.size());
  }