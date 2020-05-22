assert comparison >= 0;
        if (currentNode.hasRightChild())
            currentNode = currentNode.getRightChild();
        else {
            found = true;
            currentNode.setRightChild(new BinaryNode<T>(newEntry));
        }