class Node {
  ...
  public void addUser(User user) {
    if (!users.contains(user)) {
      users.add(user);
      user.addNode(this);
    }
  }
}

class User {
  ...
  public void addNode(Node node) {
    if (!nodeList.contains(node)) {
      nodeList.add(node);
      node.addUser(this);
    }
  }
}