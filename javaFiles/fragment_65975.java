class Card {
     //some stuff here
}

class Land extends Card {
    private boolean isBasic;
    public void isBasic(){
        return isBasic;
    }
}

class UsesCards extends SomethingElse {
    //initialize variables like SIZE
    Card cardList = new Card[SIZE];

    public void addCard(Card card){
        // Checking card's actual class.
        if (card instanceof Land && ((Land)card).isBasic()){
            //the rest
        }
    }
}