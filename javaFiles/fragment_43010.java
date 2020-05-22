for(int i=0;i < size;i++) 
{ 
  Joke tempJoke = new Joke(); 
  tempJoke.setJoke(jokeStrings[i]); 
  jokeList.add(tempJoke); 
  addJoke(tempJoke); 
}