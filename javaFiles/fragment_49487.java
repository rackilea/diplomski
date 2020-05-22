class Factory {    
    private Vector<Action> actions = new Vector<Action>();

    public Factory() {                       
        actions.add(new RunAction());
        actions.add(new ClimbAction());
    }

    public Vector getActions(){ return actions; }
    public void setActions(Vector v){ actions = v; }
}

public class Game {

    private Vector<Action> actions = new Vector<Action>();

    public  Game(Factory fact) {
        //add every action in factory to game actions.
        for(Action a : fact.getActions())
            actions.add(a);
     }
}