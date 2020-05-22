ArrayList<String> words = new ArrayList();

int[] occurrence = new int[2000];
Arrays.sort(data);


int nwords = 0;
occurrence[nwords]=1;
words.add(data[0]);        
for (int i = 1; i < data.length; i ++ ) {
    if(!data[i].equals(data[i-1])){ //if a new word is found
        words.add(data[i]);         //put it into the words ArrayList
        nwords++;                   //increment the index
        occurrence[nwords]=0;       //initialize its occurrence counter
    }
    occurrence[nwords]++;           //increment the occurrence counter
}

int max;
for(int k=0; k<5; k++){  //loop to find 5 times the most talked word
  max = 0;               //index of the most talked word
  for(int i = 1; i<words.size(); i++) { //for every word
    if(occurrence[i]>occurrence[max]) { //if it is more talked than max
      max = i;                          //than it is the new most talked
    }
  }
  println("The most talked keyword is " + words.get(max) + " occuring " + occurence[max] + " times.");
  occurence[max]=0;
}