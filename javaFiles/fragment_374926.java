public class State{
    private Map<Character,State> transitions=new HashMap<Character,State>();

    public void addTransition(char ch,State st){
        transitions.put(ch,st);
    }

    public State next(char ch){
        return transitions.get(ch);
    }

    private boolean fin=false;
    public boolean isFinal(){return fin;}
    public boolean setFinal(boolean f){fin=f;}        


}