private Set<Node> markedNumbers = new HashSet<>();

...
public void marked(Object object){
    Label label = (Label) object;
    markedNumbers.add(label);
}
...

public void onDeleteButton(){
    for(Node node :markedNumbers){
        VBoxId.getChildren().remove(node);
    }
    markedNumbers.clear();
}