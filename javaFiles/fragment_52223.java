public void search(Node node) {
node.visit();

while (node.randomExist()) {
    int direction = node.getRandom();
    if (direction == LEFT && leftOK(node) && !left(node).isVisited()) {
        node.breakLeft();
        left(node).breakRight();
        search(left(node));
        return;
    }

    if (direction == RIGHT && rightOK(node) && !right(node).isVisited()){
        node.breakRight();
...