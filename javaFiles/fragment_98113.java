Object next = input.readObject();
if (next instanceof Game) {
    game1 = (Game)next;
    //...
}
else if (next instanceof String) {
    message = (String)next;
    //...
}
else {
    System.out.println("Unexpected object type:  " + next.getClass().getName());
}