ArrayList<WordData> unique = new ArrayList<WordData>();

for(int i=0;i<3;i++)
{
    WordData tempWordData = new WordData(); 
    String temp_word = word.get(i);
    tempWordData.addWord(temp_word);
    unique.add(tempWordData);               
}