class Node extends Observable {

    public Node(Observer observer){
        addObserver(observer);
    }

    public void addRelationship(Relation relation){
        relations.put(relation.key,relation);
        setChanged();
        notifyObservers(relation);
    }
}


class Graph implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Relation relation = (Observable)arg;
        relations.add(relation.key,relation);
    }
}