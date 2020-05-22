while{
...
  boolean isOtherVoyelsThanYfound = false;
  int countY = 0;

  for (int i = 0; i < Vowels.length(); i++) {
    char c = Vowels.charAt(i);

    if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u' ) {
         count++;
         isOtherVoyelsThanYfound = true;
    }
    else if (c == 'y'){
        countY++;
    }
  }

  if (!isOtherVoyelsThanYfound){
    count += countY;
  }
... 
}