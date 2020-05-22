public class main {

private hits hits_instance

//constructor

main(){ hits_instance = new hits(); }

//this method will add your cards

public void addCards(){
// frame = whatever frame you are using
frame.add(hits_instance.getCards());

}

}

public class hits {

private cards cards_instance;

hits(){ cards_instance= new cards();}

public JLabel getCards() {return cards_instance.getCard(randomNumber);}
}