public static void generateValues(ArrayList<Float> theList) {

 for (int j = 0; j < theList.size(); j++) {
     if (dummyValues.size()==0){
             dummyValues.add(j, theList.get(j));
       }
      else if(dummyValues.size()==theList.size()){
            dummyValues.set(j, theList.get(j));
               }     
     else{
         dummyValues.add(theList.get(j));
    }
}