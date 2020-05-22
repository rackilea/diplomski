public ArrayList<Duck> olderThan(int someAge){
        //Create a Result ArrayList
        olderThan = new ArrayList<Duck>(someAge);
        //Loop over all the Ducks
        for(int i=0; i< numberOfDucks; i++){
            if (myDucks[i]== someAge){
                return i;
            }
        }
            //Test if the current Duck is older than someAge
            //if so add it to the Result ArrayList
        //Return the Return ArrayList of Ducks older than someAge
    }