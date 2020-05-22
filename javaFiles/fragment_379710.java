public static class DLList {
   private Node firstNode = null;

    public void addFirst(Node n) {

        //do something with the first node before it is assigned to the n
        if (firstNode != null){
            SolutionDLL.Node tempNode = new SolutionDLL.Node(
            firstNode.getElement(),
            firstNode.getNext(), 
            firstNode.getPrevious()); 
         }
         firstNode = n;
        // do something
    }
}