// list that fires updates if any members change visibility:
ObservableList<Node> children = 
    FXCollections.observableArrayList(n -> new Observable[] {n.visibleProperty()});
// make the new list always contain the same elements as the pane's child list:
Bindings.bindContent(children, parentPane.getChildren());
// filter for visible nodes:
ObservableList<Node> visibleChildren = children.filter(Node::isVisible);
// and now see if it's empty:
BooleanBinding someVisibleChildren = Bindings.isNotEmpty(visibleChildren);
// finally:
parentPane.visibleProperty().bind(someVisibleChildren);