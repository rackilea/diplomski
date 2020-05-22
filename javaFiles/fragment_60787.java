public  boolean addPresent(Present present){

    if(totWeight+present.getWeight()<=maxWeight){
        presents.add(present);
        presents1.add(present);
        totWeight += present.getWeight();
        return true;
    }
    return false;
}