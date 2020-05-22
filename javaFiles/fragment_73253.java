ArrayList<String> tmpList = new ArrayList<String>();

for(int i = 0; i < myArray.Length; i++){
   if(myArray[i].contains("Something."){ // Use whatever criteria you need here.
      tmpList.Add(myArray[i]);
   }
}

myFunction(tmpList);