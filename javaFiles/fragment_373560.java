public void addWord( String word, String prefix, String linenum )
{   //if word exists, just add the prefix
    //theCollection = your ArrayList of WordRecord
    boolean findIt = false;
    for(WordRecord wordRecord : theCollection){
        if(wordRecord.getWord().equals(word)){
           wordRecord.addPrefix(prefix); //this method should be add a prefix
           findIt = true; 
           break;
        }
    }
    if(!findIt){
     WordRecord newRecord = new WordRecord();
     newRecord.setWord(word);
     newRecord.addPrefix(prefix);
     newRecord.setLineNum(linenum);
     //... and add
     theCollection.add(newRecord);
    }
 }