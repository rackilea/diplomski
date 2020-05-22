public void deleteNode(Student targetNode) {
    Node position = head;
    Node previous = null;
    while (position != null) {
    {
        if (position.getData().equals(targetNode)) {
            if (previous == null) {
                head = position.getLink();
            }
            else {
                previous.setLink(position.getLink());
            }
            break;
        }
        else {
            previous = position;
            position = position.getLink();
        }
    }
}