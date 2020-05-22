Button a = new Button();
a.setUserData("A");
Button b = new Button();
b.setUserData("B");
Button c = new Button();
c.setUserData("C");
somePane.getChildren().addAll(a, b, c);

// ...

private Node getByUserData(Parent parent, Object data) {
    for (Node n : parent.getChildren()) {
        if (data.equals(n.getUserData())) {
            return n ;
        }
    return null ;
}