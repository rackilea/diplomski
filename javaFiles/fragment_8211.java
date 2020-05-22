public Value delete (int key) {

    //check if list is empty
    if (head == null)
        //the key does not exist. return null to let the method caller know
        return null; 

    //check if we're deleting the root node
    if (key == head.getKey()) {
        //set the value of what we're deleting
        Value val = head.getNode().getValue();
        //now the first in the list is where head was pointing
        head = head.getNext();
        //there is now one less item in your list. update the size
        total--;
        //return what we're deleting
        return val;
    }

    // general case: while the next node exists, check its key
    for (Node x = head; x.getNext() != null; x = x.getNext()) {

        //check if the next node's key matches
        if (key == x.getNext().getKey()) {

            //set value of what we're deleting
            Value val = x.getNext().getNode().getValue();

            //x now points to where the node we are deleting points
            x.setNext(x.getNext().getNext());

            //there is now one less item in the list. update the size
            total--;

            //return what we're deleting
            return val; 
        }
    }


    //if we didn't find the key above, it doesn't exist. return null to let the
    // method caller know.
    return null; 
}