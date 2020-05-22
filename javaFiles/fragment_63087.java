public void deleteNode(Student targetNode) {
    Node position = head;
    if (position.getData().equals(targetNode)) {
        head = position.getLink();
    }
    else {

        Node nextPosition1;
        Node nextPosition2;
        while (position.getLink() != null) {

            if (position.getLink().getData().equals(targetNode)) {

                nextPosition1 = position.getLink();
                nextPosition2 = nextPosition1.getLink();
                position.setLink(nextPosition2);

            } else {
                position = position.getLink(); 
            }
        }
    }
}