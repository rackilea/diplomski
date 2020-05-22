@Override
public boolean equals(Object t){
    if(!(t instanceof Card)){
        return false; 
    }
    Card c = (Card)t;
    //Compare however you want, ie
    return (c.getValue() == this.getValue()) & (c.getColor().equals(this.getColor());
}