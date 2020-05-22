public static int diffValues(int[] numArray){
    int numOfDifferentVals = 0;

    ArrayList<Integer> diffNum = new ArrayList<>();

    for(int i=0; i<numArray.length; i++){
        if(!diffNum.contains(numArray[i])){
            diffNum.add(numArray[i]);
        }
    }

    if(diffNum.size()==1){
            numOfDifferentVals = 0;
    }
    else{
          numOfDifferentVals = diffNum.size();
        } 

   return numOfDifferentVals;
}