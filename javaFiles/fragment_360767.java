public Dog(){
    this("");  //invoke Dog(String)
}

public Dog(String theName){
    age = 0;
    weight = 0;
    name = theName;
    bark = "";
    hairLength = false; 
    tail = TailType.NONE;   
}