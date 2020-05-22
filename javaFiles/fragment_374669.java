private Card[] theDeck; // Your constructor is not referring to this!
private int top; 
// add more instance variables if needed    

public Deck(){
        top = 0;
        Card[] theDeck = new Card[52]; // You defined a local theDeck variable!
        for(int s = 1; s <= 4; s++)
        {
            for (int v = 1; v <= 13; v++)
            {
                for (int i = 0; i < theDeck.length; i++)
                {

                    theDeck[i] = new Card(s,v);
                }
            }
        }   
    }