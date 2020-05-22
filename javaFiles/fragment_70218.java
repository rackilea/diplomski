// this is a very contrived example
public class EmptyList extends ArrayList {
    @Override
    public boolean add(Object o){
        return false; // will not add things to a list
    }
}