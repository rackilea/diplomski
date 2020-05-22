String [] titleWords = title.split(" ");

ArrayList<String> wordList = Arrays.asList(myFirstStringArray);

for (String word : titleWords)
{
    if(wordList.contains(word))
    {
        /*do something here. you can get the index of the word by 
          wordList.indexOf(word); this index will the same as the index in myFirstStringArray*/
        break;
    }
}