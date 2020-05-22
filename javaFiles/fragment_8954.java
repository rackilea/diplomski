public Node<Item> listSearch(Item key)
    {
        Node<Item> currentNode = head ;   
        while (currentNode != null && !currentNode.key.equals(key))
                currentNode = currentNode.next ;
        return currentNode ;
    }