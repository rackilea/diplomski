public display() {
   doDisplay(this);
}

private void doDisplay(LinkedListImpl item) {
    if(item.next) // implicit != null
    {
        doDisplay(item.next);
    }
    System.out.println("\n\t" + temp.element + "\n");  // this line goes before
                                                       // the if statement for
                                                       // regular ordering
}