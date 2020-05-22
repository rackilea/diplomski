public Dog(String myName, double myWeight){
    name = myName;
    weight = myWeight;

}

public String toString(){
    if(myWeight>0 && myWeight<500) {
        return "This dog is named " + name + " and weighs " + weight + " pounds";
    } else {
        return "This dog is named " + name + " and has an invalid weight entered.";
    }
}