public Boolean somethingIsThere(GameObject user){
    for(int i = 0; i < theseWalls.size(); i++){
        GameObject a = (Wall) theseWalls.get(i); 

        if( user.returnPosition().equals(a.returnPosition())){
            isSomethingThere= true;
        } else {
            isSomethingThere= false;
        }
    }
    return isSomethingThere;
}